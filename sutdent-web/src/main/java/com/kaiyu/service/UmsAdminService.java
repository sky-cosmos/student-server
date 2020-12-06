package com.kaiyu.service;

import com.github.pagehelper.PageInfo;
import com.kaiyu.domain.UmsAdmin;
import com.kaiyu.dto.AdminParam;
import com.kaiyu.dto.UmsAdminQueryParam;

import java.util.List;

public interface UmsAdminService {
    UmsAdmin login(AdminParam sysUser);
    List<UmsAdmin> list(PageInfo loginRq);
     UmsAdmin getAdminById(Long attribute);
    int insertt(UmsAdmin umsAdmin);

    int update(UmsAdmin admin);

    int delete(Long adminId);

    /**
     * 第二部
     * @param loginRq
     * @return
     */
    List<UmsAdmin> query(UmsAdminQueryParam loginRq);
}


