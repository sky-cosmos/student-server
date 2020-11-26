package com.kaiyu.web.service;

import com.github.pagehelper.PageInfo;
import com.kaiyu.mbg.domain.UmsAdmin;

import java.util.List;

public interface UmsAdminService {
    UmsAdmin login(UmsAdmin sysUser);

    UmsAdmin getAdminById(Long attribute);
    UmsAdmin getAdminByUsername(String userName);

    List<UmsAdmin> list(PageInfo loginRq);
}


