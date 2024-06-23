package com.spldeolin.satisficing.security.service.service;

import com.github.pagehelper.PageInfo;
import com.spldeolin.satisficing.security.service.javabean.req.ListDepartmentsReqDto;
import com.spldeolin.satisficing.security.service.javabean.resp.ListDepartmentsRespDto;

/**
 * @author Allison 1875
 */
public interface ListDepartmentsService {

    PageInfo<ListDepartmentsRespDto> listDepartments(ListDepartmentsReqDto req);

}
