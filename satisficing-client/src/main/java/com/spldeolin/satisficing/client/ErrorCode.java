package com.spldeolin.satisficing.client;

/**
 * @author Deolin 2024-04-01
 */
public interface ErrorCode {

    /**
     * 非法请求（Not Found、参数不正确、报文不正确等）
     */
    ErrorCode ILLEGAL_REQUEST = () -> "400";

    /**
     * 服务端异常（网络错误、数据库错误、服务端BUG等）
     */
    ErrorCode SERVER_EXCEPTION = () -> "500";

    /**
     * 通用业务异常
     */
    ErrorCode GENERAL_BIZ_EXCEPTION = () -> "1001";

    String declare();

}