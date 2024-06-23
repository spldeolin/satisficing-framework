package com.spldeolin.satisficing.security.service.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.PageInfo;
import com.spldeolin.satisficing.client.RequestResult;
import com.spldeolin.satisficing.security.service.javabean.req.ListDepartmentsReqDto;
import com.spldeolin.satisficing.security.service.javabean.resp.ListDepartmentsRespDto;
import com.spldeolin.satisficing.security.service.service.ListDepartmentsService;

/**
 * 部门管理
 *
 * @author Deolin 2024-06-23
 */
@RestController
public class DepartmentController {

    @Autowired
    private ListDepartmentsService listDepartmentsService;

    /**
     * 部门列表
     */
    @PostMapping("listDepartments")
    public RequestResult<PageInfo<ListDepartmentsRespDto>> listDepartments(
            @RequestBody @Valid ListDepartmentsReqDto req) {
        return RequestResult.success(listDepartmentsService.listDepartments(req));
    }

}
