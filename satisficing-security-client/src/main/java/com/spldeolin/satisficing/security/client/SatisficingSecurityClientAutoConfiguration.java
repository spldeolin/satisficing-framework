package com.spldeolin.satisficing.security.client;

import javax.annotation.PostConstruct;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Deolin 2024-06-02
 */
@Configuration
@ComponentScan("com.spldeolin.satisficing.security.client")
@EnableFeignClients("com.spldeolin.satisficing.security.client")
@Slf4j
public class SatisficingSecurityClientAutoConfiguration {

    @PostConstruct
    public void postConstruct() {
        log.info("satisficing-security-client is auto-configured");
    }

}
