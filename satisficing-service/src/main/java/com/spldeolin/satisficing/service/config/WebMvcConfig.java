package com.spldeolin.satisficing.service.config;

import java.util.Collections;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Web MVC相关配置
 *
 * @author Deolin 2024-06-03
 */
@Configuration
public class WebMvcConfig {

    @Autowired
    private DispatcherServlet dispatcherServlet;

    @Autowired
    private WebProperties webProperties;

    /**
     * 将404 Not Found设置为抛出异常到统一异常处理
     *
     * 通过将spring.mvc.throw-exception-if-no-handler-found强制指定为true，
     * 将spring.web.resources.add-mappings强制指定设置为false实现的，
     * 再在application.yml中设置它们将不再有效
     *
     * @author Deolin 2024-06-03
     */
    @PostConstruct
    public void forceThrowExceptionIfNoHandlerFound() {
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
        webProperties.getResources().setAddMappings(false);
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> filterRegistrationBean() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOriginPatterns(Collections.singletonList("*"));
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);
        corsConfiguration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);

        CorsFilter corsFilter = new CorsFilter(source);

        FilterRegistrationBean<CorsFilter> filterRegistrationBean = new FilterRegistrationBean<>(corsFilter);
        filterRegistrationBean.setOrder(Integer.MIN_VALUE);
        return filterRegistrationBean;
    }

}
