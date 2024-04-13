package com.spldeolin.satisficing.framework.api.javabean;

import org.slf4j.MDC;
import com.spldeolin.satisficing.framework.api.ErrorCode;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

/**
 * 请求结果
 *
 * @author Deolin 2023-04-13
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public final class RequestResult<T> {

    /**
     * 错误码，null代表请求成功
     */
    ErrorCode errorCode;

    /**
     * 请求成功时的返回数据
     */
    T data;

    /**
     * 请求失败时的错误信息
     */
    String errorMsg;

    /**
     * 请求的链路ID
     */
    String traceId;

    private RequestResult() {
    }

    public static <T> RequestResult<T> success() {
        return success(null);
    }

    public static <T> RequestResult<T> success(T data) {
        RequestResult<T> result = new RequestResult<>();
        result.setErrorCode(null);
        result.setData(data);
        result.setTraceId(MDC.get("traceId"));
        return result;
    }

    public static RequestResult<Void> failure(ErrorCode errorCode, String errorMsg) {
        if (errorCode.declare() == null) {
            log.warn("errorCode不应为null");
        }
        RequestResult<Void> result = new RequestResult<>();
        result.setErrorCode(errorCode);
        result.setErrorMsg(errorMsg);
        result.setTraceId(MDC.get("traceId"));
        return result;
    }

}
