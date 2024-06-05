package com.spldeolin.satisficing.security.service.service;

import com.spldeolin.satisficing.security.client.javabean.req.IsLoginReqDto;
import com.spldeolin.satisficing.security.client.javabean.resp.IsLoginRespDto;
import com.spldeolin.satisficing.security.service.javabean.req.LoginByCodeReqDto;
import com.spldeolin.satisficing.security.service.javabean.req.LoginReqDto;
import com.spldeolin.satisficing.security.service.javabean.resp.LoginByCodeRespDto;
import com.spldeolin.satisficing.security.service.javabean.resp.LoginRespDto;

/**
 * @author Deolin 2024-05-31
 */
public interface SsoService {

    LoginRespDto login(LoginReqDto req);

    LoginByCodeRespDto loginByCode(LoginByCodeReqDto req);

    IsLoginRespDto isLogin(IsLoginReqDto req);

    void logout();

}
