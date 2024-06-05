package com.spldeolin.satisficing.security.service.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.spldeolin.satisficing.security.service.entity.UserEntity;
import com.spldeolin.satisficing.security.service.javabean.cond.QueryUserCond;
import com.spldeolin.satisficing.security.service.javabean.req.ListUsersReqDto;
import com.spldeolin.satisficing.security.service.javabean.resp.ListUsersRespDto;
import com.spldeolin.satisficing.security.service.mapper.UserMapper;
import com.spldeolin.satisficing.security.service.service.ListUsersService;
import com.spldeolin.satisficing.service.util.PageUtils;
import com.spldeolin.satisficing.service.util.TimeUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>Allison 1875 Lot No: HT1001S-77216521
 *
 * @author Deolin
 */
@Slf4j
@Service
public class ListUsersServiceImpl implements ListUsersService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<ListUsersRespDto> listUsers(ListUsersReqDto req) {
        final QueryUserCond queryUserCond = new QueryUserCond();
        queryUserCond.setUsername(req.getUsername());
        queryUserCond.setMobile(req.getMobile());
        queryUserCond.setNickName(req.getNickName());
        queryUserCond.setCreateTime(TimeUtils.toggleToDayStart(req.getCreateTimeLeft()));
        queryUserCond.setCreateTimeEx(TimeUtils.toggleToDayEnd(req.getCreateTimeRight()));
        List<UserEntity> users = userMapper.queryUserEx(queryUserCond);
        if (users.isEmpty()) {
            return new PageInfo<>(Lists.newArrayList());
        }

        List<ListUsersRespDto> dtos = Lists.newArrayList();
        for (UserEntity user : users) {
            ListUsersRespDto dto = new ListUsersRespDto();
            dto.setUserUuid(user.getUserUuid());
            dto.setUsername(user.getUsername());
            dto.setMobile(user.getMobile());
            dto.setNickName(user.getNickName());
            dto.setCreateTime(user.getCreateTime());
            dtos.add(dto);
        }

        return PageUtils.transferType(users, dtos);
    }

}
