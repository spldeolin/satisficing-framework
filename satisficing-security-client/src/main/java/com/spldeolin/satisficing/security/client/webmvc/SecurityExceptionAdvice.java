package com.spldeolin.satisficing.security.client.webmvc;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.spldeolin.satisficing.client.javabean.RequestResult;
import com.spldeolin.satisficing.security.client.enums.SecurityErrorCode;
import com.spldeolin.satisficing.security.client.exception.UnauthcRequestException;
import lombok.extern.slf4j.Slf4j;

/**
 * 用于统一异常处理的ControllerAdvice
 *
 * @author Deolin 2023-04-13
 */
@RestControllerAdvice
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SecurityExceptionAdvice {

    /**
     * 未认证的请求
     */
    @ExceptionHandler(UnauthcRequestException.class)
    public RequestResult<?> handler(UnauthcRequestException e) {
        return RequestResult.failure(SecurityErrorCode.NO_AUTHC, e.getMessage());
    }

}