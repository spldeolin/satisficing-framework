package com.spldeolin.satisficing.security.service.service.impl;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.spldeolin.satisficing.security.service.entity.RoleEntity;
import com.spldeolin.satisficing.security.service.javabean.req.ListRolesReqDto;
import com.spldeolin.satisficing.security.service.javabean.resp.ListRolesRespDto;
import com.spldeolin.satisficing.security.service.mapper.RoleMapper;
import com.spldeolin.satisficing.security.service.service.ListRolesService;
import com.spldeolin.satisficing.service.util.PageUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>Allison 1875 Lot No: HT1001S-858BE8C1
 *
 * @author Allison 1875
 */
@Slf4j
@Service
public class ListRolesServiceImpl implements ListRolesService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public PageInfo<ListRolesRespDto> listRoles(ListRolesReqDto req) {
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<RoleEntity> roles = roleMapper.queryRole(req.getRoleName(), req.getDescription());
        if (CollectionUtils.isEmpty(roles)) {
            return new PageInfo<>();
        }

        List<ListRolesRespDto> dtos = Lists.newArrayList();
        for (RoleEntity role : roles) {
            ListRolesRespDto dto = new ListRolesRespDto();
            dto.setRoleId(role.getId());
            dto.setRoleName(role.getRoleName());
            dto.setDescription(role.getDescription());
            dto.setCreateTime(role.getCreateTime());
            dtos.add(dto);
        }

        return PageUtils.transferType(roles, dtos);
    }

}
