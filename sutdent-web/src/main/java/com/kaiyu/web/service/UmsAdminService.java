package com.kaiyu.web.service;

import com.github.pagehelper.PageInfo;
import com.kaiyu.mbg.domain.UmsAdmin;
import com.kaiyu.web.dto.UmsAdminQueryParam;

import java.util.List;

public interface UmsAdminService {
    UmsAdmin login(UmsAdmin sysUser);

    UmsAdmin getAdminById(Long attribute);
    UmsAdmin getAdminByUsername(String userName);

    List<UmsAdmin> list(PageInfo loginRq);
    int insertt(UmsAdmin umsAdmin);

    int update(UmsAdmin admin);

    int delete(Long adminId);

    List<UmsAdmin> query(UmsAdminQueryParam loginRq);
}


