package com.kaiyu.web.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.kaiyu.mbg.mapper.UmsAdminRoleRelationMapper;
import com.kaiyu.web.service.UmsAdminRoleRelationService;
@Service
public class UmsAdminRoleRelationServiceImpl implements UmsAdminRoleRelationService{

    @Resource
    private UmsAdminRoleRelationMapper umsAdminRoleRelationMapper;

}
