package com.spldeolin.satisficing.security.client.exception;

import com.spldeolin.satisficing.client.BaseException;

/**
 * 未认证的请求
 *
 * @author Deolin 2024-05-30
 */
public class UnauthcRequestException extends BaseException {

    private static final long serialVersionUID = 8539803572446960571L;

    public UnauthcRequestException(String message) {
        super(message);
    }

}
