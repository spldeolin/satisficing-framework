package com.spldeolin.satisficing.framework.app.config;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Deolin 2024-04-03
 */
@Configuration
public class ThreadPoolConfig {

    @Value("${thread-pool.core-size}")
    private Integer coreSize;

    @Value("${thread-pool.maximum-size}")
    private Integer maximumSize;

    @Value("${thread-pool.queue-capacity}")
    private Integer queueCapacity;

    @Value("${thread-pool.keep-alive-seconds}")
    private Integer keepAliveSeconds;

    @Bean("globalThreadPoolExecutor")
    public ThreadPoolExecutor threadPoolExecutor() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(coreSize, maximumSize, keepAliveSeconds, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(queueCapacity), new ThreadPoolExecutor.AbortPolicy());
        return executor;
    }

}