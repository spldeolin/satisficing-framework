package com.spldeolin.satisficing.framework.app.exception;

import com.spldeolin.satisficing.framework.api.ErrorCode;

/**
 * 业务异常
 *
 * @author Deolin 2023-04-13
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = -4104806330438981374L;

    private final String errorMessage;

    /**
     * 抛出异常时显式指定具体的ErrorMessage
     */
    public BizException(String message) {
        super(message);
        this.errorMessage = message;
    }

    /**
     * 业务异常的errorCode默认为1001，如果需要自定义errorCode，重写这个方法
     */
    public ErrorCode errorCode() {
        return ErrorCode.GENERAL_BIZ_EXCEPTION;
    }

    /**
     * 显式指定具体的ErrorMessage
     */
    public final String getErrorMessage() {
        return errorMessage;
    }

}