package com.kaiyu.web.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.kaiyu.mbg.mapper.UmsRoleMapper;
import com.kaiyu.web.service.UmsRoleService;
@Service
public class UmsRoleServiceImpl implements UmsRoleService{

    @Resource
    private UmsRoleMapper umsRoleMapper;

}
