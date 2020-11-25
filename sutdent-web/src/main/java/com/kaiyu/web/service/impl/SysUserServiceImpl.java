package com.kaiyu.web.service.impl;

import com.kaiyu.mbg.domain.SysUser;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.kaiyu.mbg.mapper.SysUserMapper;
import com.kaiyu.web.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser login(SysUser loginRq) {
        return sysUserMapper.selectOne(loginRq);
    }
}





