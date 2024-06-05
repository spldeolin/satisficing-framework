package com.spldeolin.satisficing.security.service;

import javax.annotation.PostConstruct;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Deolin 2024-06-02
 */
@Configuration
@ComponentScan("com.spldeolin.satisficing.security.service")
@MapperScan("com.spldeolin.satisficing.security.service.mapper")
@Slf4j
public class SatisficingSecurityAppAutoConfiguration {

    @PostConstruct
    public void postConstruct() {
        log.info("satisficing-security-service is auto-configured");
    }

}
