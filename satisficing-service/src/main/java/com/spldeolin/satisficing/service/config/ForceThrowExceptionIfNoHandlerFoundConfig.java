package com.spldeolin.satisficing.service.config;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * 将404 Not Found设置为抛出异常到统一异常处理
 *
 * 通过将spring.mvc.throw-exception-if-no-handler-found强制指定为true，
 * 将spring.web.resources.add-mappings强制指定设置为false实现的，
 * 再在application.yml中设置它们将不再有效
 *
 * @author Deolin 2024-06-03
 */
@Configuration
public class ForceThrowExceptionIfNoHandlerFoundConfig {

    @Autowired
    private DispatcherServlet dispatcherServlet;

    @Autowired
    private WebProperties webProperties;

    @PostConstruct
    public void throwExceptionIfNoHandlerFound() {
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
        webProperties.getResources().setAddMappings(false);
    }

}
