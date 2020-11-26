package com.kaiyu.web.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.kaiyu.mbg.mapper.UmsAdminPermissionRelationMapper;
import com.kaiyu.web.service.UmsAdminPermissionRelationService;
@Service
public class UmsAdminPermissionRelationServiceImpl implements UmsAdminPermissionRelationService{

    @Resource
    private UmsAdminPermissionRelationMapper umsAdminPermissionRelationMapper;

}
