package com.spldeolin.satisficing.service.enumcache;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.google.common.base.CaseFormat;
import com.google.common.collect.Maps;
import com.spldeolin.satisficing.client.EnumAncestor;
import com.spldeolin.satisficing.client.javabean.CodeAndTitle;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Deolin 2020-09-17
 */
@Component
@Slf4j
public class EnumCache implements InitializingBean {

    public static final String keyConstantPrefix = "enumCache:";

    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    private RedissonClient redissonClient;

    public LinkedHashMap<String, String> getCodeAndTitles(String cacheKey) {
        LinkedHashMap<String, String> result = Maps.newLinkedHashMap();
        for (Entry<Object, Object> entry : redissonClient.getMap(cacheKey).entrySet()) {
            result.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return result;
    }

    @Override
    public void afterPropertiesSet() {
        detectAndSaveToCache();
    }

    public void detectAndSaveToCache() {
        log.info("applicationName={}", applicationName);

        Reflections reflections = new Reflections(
                new ConfigurationBuilder().setUrls(ClasspathHelper.forPackage("")).setScanners(new SubTypesScanner()));

        // 删除这个服务在Redis中所有既存的枚举缓存
        redissonClient.getKeys().deleteByPattern(keyConstantPrefix + applicationName + ":*");

        for (@SuppressWarnings("rawtypes") Class<? extends EnumAncestor> anEnum : reflections.getSubTypesOf(
                EnumAncestor.class)) {
            String key = buildRedisKey(anEnum, applicationName);
            RMap<String, Object> enumCache = redissonClient.getMap(key);
            enumCache.clear();

            for (EnumAncestor<?> enumConstant : anEnum.getEnumConstants()) {
                CodeAndTitle codeAndTitle = enumConstant.asJavabean();
                enumCache.put(codeAndTitle.getCode().toString(), codeAndTitle.getTitle());
            }
        }
    }

    private String buildRedisKey(Class<?> clazz, String applicationName) {
        String enumName = clazz.getSimpleName();
        if (enumName.endsWith("Enum")) {
            enumName = enumName.substring(0, enumName.length() - 4);
        }
        enumName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, enumName);
        return keyConstantPrefix + applicationName + ":" + enumName;
    }

}