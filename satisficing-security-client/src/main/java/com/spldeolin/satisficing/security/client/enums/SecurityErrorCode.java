package com.spldeolin.satisficing.security.client.enums;

import com.spldeolin.satisficing.client.ErrorCode;
import lombok.AllArgsConstructor;

/**
 * @author Deolin 2024-06-08
 */
@AllArgsConstructor
public enum SecurityErrorCode implements ErrorCode {

    NO_AUTHC("E403", null),

    ;

    private final String code;

    private final String defaultMsg;

    @Override
    public String code() {
        return code;
    }

    @Override
    public String defaultMsg() {
        return defaultMsg;
    }
}
