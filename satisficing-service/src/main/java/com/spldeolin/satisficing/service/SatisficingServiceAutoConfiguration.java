package com.spldeolin.satisficing.service;

import javax.annotation.PostConstruct;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Deolin 2024-06-02
 */
@Configuration
@ComponentScan("com.spldeolin.satisficing.service")
@Slf4j
public class SatisficingServiceAutoConfiguration {

    @PostConstruct
    public void postConstruct() {
        log.info("satisficing-service is auto-configured");
    }

}
