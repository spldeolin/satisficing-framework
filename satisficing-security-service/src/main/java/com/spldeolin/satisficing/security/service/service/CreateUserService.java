package com.spldeolin.satisficing.security.service.service;

import com.spldeolin.satisficing.security.service.javabean.req.CreateUserReqDto;
import com.spldeolin.satisficing.security.service.javabean.resp.CreateUserRespDto;

/**
 * <p>Allison 1875 Lot No: HT1001S-D3209C95
 *
 * @author Deolin
 */
public interface CreateUserService {

    CreateUserRespDto createUser(CreateUserReqDto req);

}
