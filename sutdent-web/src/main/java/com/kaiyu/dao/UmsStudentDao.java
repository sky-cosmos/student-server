package com.kaiyu.dao;

import com.kaiyu.domain.UmsAdmin;
import com.kaiyu.domain.UmsStudent;
import com.kaiyu.dto.UmsStudentParam;
import com.kaiyu.dto.UmsStudentQueryParam;

import java.util.List;

public interface UmsStudentDao {
    int insert(UmsStudent umsStudent);

    int updateByPrimaryKey(UmsStudentParam umsStudent);

    UmsStudent selectByPrimaryKey(Integer umsStudentId);

    int deleteByPrimaryKey(Integer sutudenId);

    List<UmsStudent> selectAll();
    List<UmsStudent> likeQuery(UmsStudentQueryParam loginRq);
}
