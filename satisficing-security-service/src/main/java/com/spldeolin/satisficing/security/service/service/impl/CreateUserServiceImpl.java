package com.spldeolin.satisficing.security.service.service.impl;

import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.spldeolin.satisficing.security.client.javabean.LoginSession;
import com.spldeolin.satisficing.security.service.entity.UserEntity;
import com.spldeolin.satisficing.security.service.javabean.req.CreateUserReqDto;
import com.spldeolin.satisficing.security.service.mapper.UserMapper;
import com.spldeolin.satisficing.security.service.service.CreateUserService;
import com.spldeolin.satisficing.service.exception.BizException;
import com.spldeolin.satisficing.service.id.SnowFlake;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>Allison 1875 Lot No: HT1001S-D3209C95
 *
 * @author Deolin
 */
@Service
@Slf4j
public class CreateUserServiceImpl implements CreateUserService {

    private static final String defaultPassword = "123456";

    @Autowired
    private SnowFlake snowFlake;

    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public void createUser(CreateUserReqDto req) {
        UserEntity duplication = userMapper.queryUserEx2(null, req.getUsername(), req.getMobile());
        if (duplication != null) {
            if (duplication.getUsername().equals(req.getUsername())) {
                throw new BizException("用户名已存在");
            }
            if (duplication.getMobile().equals(req.getMobile())) {
                throw new BizException("手机号已存在");
            }
        }

        UserEntity user = new UserEntity();
        user.setId(snowFlake.nextId());
        user.setUserUuid(UUID.randomUUID().toString());
        user.setUsername(req.getUsername());
        user.setMobile(req.getMobile());
        user.setPassword(new BCryptPasswordEncoder().encode(defaultPassword));
        user.setNickName(req.getNickName());
        user.setCreateUserUuid(LoginSession.getCurrent().getLoginUserUuid());
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateUserUuid(LoginSession.getCurrent().getLoginUserUuid());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insert(user);
    }

}
