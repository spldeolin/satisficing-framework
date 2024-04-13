package com.spldeolin.satisficing.framework.app.trace;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import lombok.extern.slf4j.Slf4j;

/**
 * 请求轨迹过滤器
 *
 * @author Deolin 2018/12/06
 */
@Component
@Slf4j
public class HttpBodyReportFilter extends OncePerRequestFilter implements Ordered {

    @Autowired
    private HttpBodyReportExclusionHandle requestIgnoreHandleExcluded;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        // 过滤规则
        if (requestIgnoreHandleExcluded.isExcluded(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        // 请求到达时的报告
        log.info("requestArrived-{}-{}", request.getRequestURL(), MDC.get("traceId"));
        long start = System.currentTimeMillis();

        // 包装request和response
        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper(response);

        try {
            filterChain.doFilter(wrappedRequest, wrappedResponse);
        } finally {
            // 请求离开时的报告
            log.info("requestLeft-{}-{}-{}-{}\t{}\t{}", request.getRequestURL(), MDC.get("traceId"),
                    System.currentTimeMillis() - start, response.getHeader("token"), getRawRequestBody(wrappedRequest),
                    getRawResponseBody(wrappedResponse));
        }
    }

    private String getRawRequestBody(ContentCachingRequestWrapper wrappedRequest) {
        try {
            // Response Body由客户端提供，所以编码从报文中获取
            String encoding = wrappedRequest.getCharacterEncoding();
            String result = IOUtils.toString(wrappedRequest.getContentAsByteArray(), encoding);
            if (StringUtils.isEmpty(result)) {
                // 报文有body，但handler没有@RequestBody时，wrappedRequest.getInputStream()会有内容
                result = IOUtils.toString(wrappedRequest.getInputStream(), encoding);
            }
            return result;
        } catch (IOException e) {
            log.error("读取request body失败", e);
            return "";
        }
    }

    private String getRawResponseBody(ContentCachingResponseWrapper wrappedResponse) {
        try {
            String result = IOUtils.toString(wrappedResponse.getContentInputStream(),
                    wrappedResponse.getCharacterEncoding());
            wrappedResponse.copyBodyToResponse();
            return result;
        } catch (IOException e) {
            log.error("读取response body失败", e);
            return "";
        }
    }

    @Override
    public int getOrder() {
        return 1001;
    }

}
