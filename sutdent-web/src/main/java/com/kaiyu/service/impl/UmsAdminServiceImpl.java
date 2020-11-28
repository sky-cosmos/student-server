package com.kaiyu.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaiyu.dao.UmsAdminDao;
import com.kaiyu.domain.UmsAdmin;
import com.kaiyu.dto.AdminParam;
import com.kaiyu.dto.UmsAdminQueryParam;
import com.kaiyu.service.UmsAdminService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    @Resource
    private UmsAdminDao umsAdminDao;

    @Override
    public UmsAdmin login(AdminParam sysUser) {
        return umsAdminDao.selectOne(sysUser);
    }

    @Override
    public UmsAdmin getAdminById(Long attribute) {
        return umsAdminDao.selectByPrimaryKey(attribute);
    }


    @Override
    public List<UmsAdmin> list(PageInfo loginRq) {
        PageHelper.startPage(loginRq.getPageNum(),loginRq.getPageSize());
        return umsAdminDao.selectAll();
    }

    @Override
    public int insertt(UmsAdmin umsAdmin) {
        umsAdmin.setCreateTime(new Date());
        return umsAdminDao.insert(umsAdmin);
    }

    @Override
    public int update(UmsAdmin admin) {
        return umsAdminDao.updateByPrimaryKeySelective(admin);
    }

    @Override
    public int delete(Long adminId) {
        return umsAdminDao.deleteByPrimaryKey(adminId);
    }

    @Override
    public List<UmsAdmin> query(UmsAdminQueryParam loginRq) {
        PageHelper.startPage(loginRq.getPageNum(),loginRq.getPageSize());
        return umsAdminDao.likeQuery(loginRq);
    }
}
