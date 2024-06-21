package com.spldeolin.satisficing.security.service.service;

import com.github.pagehelper.PageInfo;
import com.spldeolin.satisficing.security.service.javabean.req.ListRolesReqDto;
import com.spldeolin.satisficing.security.service.javabean.resp.ListRolesRespDto;

/**
 * <p>Allison 1875 Lot No: HT1001S-858BE8C1
 *
 * @author Allison 1875
 */
public interface ListRolesService {

    PageInfo<ListRolesRespDto> listRoles(ListRolesReqDto req);

}
