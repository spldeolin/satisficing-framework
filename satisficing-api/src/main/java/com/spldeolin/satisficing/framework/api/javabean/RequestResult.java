package com.spldeolin.satisficing.framework.api.javabean;

import org.slf4j.MDC;
import com.spldeolin.satisficing.framework.api.ErrorCode;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * 请求结果
 *
 * @author Deolin 2023-04-13
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
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

    public static RequestResult<Void> success() {
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
        RequestResult<Void> result = new RequestResult<>();
        result.setErrorCode(errorCode);
        result.setErrorMsg(errorMsg);
        result.setTraceId(MDC.get("traceId"));
        return result;
    }

}
