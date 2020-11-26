package com.kaiyu.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaiyu.mbg.domain.UmsAdmin;
import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.kaiyu.mbg.mapper.UmsAdminMapper;
import com.kaiyu.web.service.UmsAdminService;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UmsAdminServiceImpl implements UmsAdminService{

    @Resource
    private UmsAdminMapper umsAdminMapper;

    @Override
    public UmsAdmin login(UmsAdmin sysUser) {
        return umsAdminMapper.selectOne(sysUser);
    }

    @Override
    public UmsAdmin getAdminById(Long attribute) {
        return umsAdminMapper.selectByPrimaryKey(attribute);
    }

    @Override
    public UmsAdmin getAdminByUsername(String userName) {
        Example example = new Example(UmsAdmin.class);
        example.createCriteria().andEqualTo("username",userName);
        return umsAdminMapper.selectOneByExample(example);
    }

    @Override
    public List<UmsAdmin> list(PageInfo loginRq) {
        PageHelper.startPage(loginRq.getPageNum(),loginRq.getPageSize());
        return umsAdminMapper.selectAll();
    }
}
