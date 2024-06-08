package com.spldeolin.satisficing.security.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.spldeolin.satisficing.client.RequestResult;
import com.spldeolin.satisficing.security.client.client.SsoClient;
import com.spldeolin.satisficing.security.client.javabean.req.IsLoginReqDto;
import com.spldeolin.satisficing.security.client.javabean.resp.IsLoginRespDto;
import com.spldeolin.satisficing.security.service.service.SsoService;

/**
 * @author Deolin 2024-06-02
 */
@Configuration
public class OverridenConfig {

    @Autowired
    private SsoService ssoService;

    @Bean
    @Primary
    public SsoClient ssoClient() {
        return new SsoClient() {
            @Override
            public RequestResult<IsLoginRespDto> isLogin(IsLoginReqDto req) {
                return RequestResult.success(ssoService.isLogin(req));
            }
        };
    }

}
