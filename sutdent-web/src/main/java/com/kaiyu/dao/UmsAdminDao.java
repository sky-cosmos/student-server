package com.kaiyu.dao;

import com.kaiyu.domain.UmsAdmin;
import com.kaiyu.dto.AdminParam;
import com.kaiyu.dto.UmsAdminQueryParam;

import java.util.List;

public interface UmsAdminDao {
    UmsAdmin selectOne(AdminParam sysUser);

    int insert(UmsAdmin umsAdmin);

    int updateByPrimaryKeySelective(UmsAdmin admin);

    int deleteByPrimaryKey(Long adminId);

    List<UmsAdmin> selectAll();

    UmsAdmin selectByPrimaryKey(Long attribute);

    List<UmsAdmin> likeQuery(UmsAdminQueryParam loginRq);
}
