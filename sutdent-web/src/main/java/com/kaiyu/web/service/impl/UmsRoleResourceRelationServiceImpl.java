package com.kaiyu.web.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.kaiyu.mbg.mapper.UmsRoleResourceRelationMapper;
import com.kaiyu.web.service.UmsRoleResourceRelationService;
@Service
public class UmsRoleResourceRelationServiceImpl implements UmsRoleResourceRelationService{

    @Resource
    private UmsRoleResourceRelationMapper umsRoleResourceRelationMapper;

}
