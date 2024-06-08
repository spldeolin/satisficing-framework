package com.spldeolin.satisficing.security.client.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import com.spldeolin.satisficing.client.RequestResult;
import com.spldeolin.satisficing.security.client.javabean.req.IsLoginReqDto;
import com.spldeolin.satisficing.security.client.javabean.resp.IsLoginRespDto;

/**
 * @author Deolin 2024-06-02
 */
@FeignClient(name = "satisficing-security-service", url = "${rpc-url.satisficing-security-service}", primary = false)
public interface SsoClient {

    @PostMapping("/isLogin")
    RequestResult<IsLoginRespDto> isLogin(IsLoginReqDto req);

}
