package com.spldeolin.satisficing.security.service.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.PageInfo;
import com.spldeolin.satisficing.client.RequestResult;
import com.spldeolin.satisficing.security.service.javabean.req.CreateUserReqDto;
import com.spldeolin.satisficing.security.service.javabean.req.ListUsersReqDto;
import com.spldeolin.satisficing.security.service.javabean.req.UpdateUserReqDto;
import com.spldeolin.satisficing.security.service.javabean.resp.CreateUserRespDto;
import com.spldeolin.satisficing.security.service.javabean.resp.ListUsersRespDto;
import com.spldeolin.satisficing.security.service.service.CreateUserService;
import com.spldeolin.satisficing.security.service.service.ListUsersService;
import com.spldeolin.satisficing.security.service.service.UpdateUserService;

/**
 * 用户管理
 *
 * @author Deolin 2024-06-03
 */
@RestController
public class UserController {

    @Autowired
    private ListUsersService listUsersService;

    @Autowired
    private CreateUserService createUserService;

    @Autowired
    private UpdateUserService updateUserService;

    /**
     * 用户列表
     * <p>Allison 1875 Lot No: HT1001S-77216521
     */
    @PostMapping("listUsers")
    public RequestResult<PageInfo<ListUsersRespDto>> listUsers(@RequestBody @Valid ListUsersReqDto req) {
        return RequestResult.success(listUsersService.listUsers(req));
    }

    /**
     * 创建用户
     * <p>Allison 1875 Lot No: HT1001S-D3209C95
     */
    @PostMapping("createUser")
    public RequestResult<CreateUserRespDto> createUser(@RequestBody @Valid CreateUserReqDto req) {
        return RequestResult.success(createUserService.createUser(req));
    }

    /**
     * 更新用户
     * <p>Allison 1875 Lot No: HT1001S-DF7438EF
     */
    @PostMapping("updateUser")
    public RequestResult<Void> updateUser(@RequestBody @Valid UpdateUserReqDto req) {
        updateUserService.updateUser(req);
        return RequestResult.success();
    }

}
