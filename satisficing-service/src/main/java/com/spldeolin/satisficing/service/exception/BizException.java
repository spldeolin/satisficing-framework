package com.spldeolin.satisficing.service.exception;

import com.spldeolin.satisficing.client.ErrorCode;
import com.spldeolin.satisficing.client.exception.BaseException;

/**
 * 业务异常
 *
 * @author Deolin 2023-04-13
 */
public class BizException extends BaseException {

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