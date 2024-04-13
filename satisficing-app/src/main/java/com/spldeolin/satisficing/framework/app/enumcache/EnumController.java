package com.spldeolin.satisficing.framework.app.enumcache;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.collect.Maps;
import com.spldeolin.satisficing.framework.api.javabean.RequestResult;

/**
 * 枚举缓存相关
 * doc-ignore
 *
 * @author Deolin 2020-09-23
 */
@RestController
public class EnumController {

    @Autowired
    private EnumCache enumCache;

    /**
     * 根据枚举名，获取多个枚举的每个枚举项
     */
    @PostMapping({"/listEnums"})
    public RequestResult<Map<String, LinkedHashMap<String, String>>> listEnums(
            @RequestBody Collection<String> enumNames) {
        Map<String, LinkedHashMap<String, String>> codesAndTitles = Maps.newHashMap();
        for (String enumName : enumNames) {
            codesAndTitles.put(enumName, enumCache.getCodeAndTitles(EnumCache.keyConstantPrefix + enumName));
        }
        return RequestResult.success(codesAndTitles);
    }

    /**
     * 刷新缓存
     */
    @PostMapping("/enum/refreshCache")
    public RequestResult<Void> refreshCache() {
        enumCache.detectAndSaveToCache();
        return RequestResult.success();
    }

}