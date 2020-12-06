package com.kaiyu.service;

import com.github.pagehelper.PageInfo;
import com.kaiyu.domain.UmsAdmin;
import com.kaiyu.domain.UmsStudent;
import com.kaiyu.dto.*;

import java.util.List;

public interface UmsStudentService {

    List<UmsStudent> list(PageInfo loginRq);

    int insert(UmsStudent umsStudent);

    int update(UmsStudentParam umsStudent);

    UmsStudent listById(Integer umsStudentId);

    List<UmsStudent> list(PageParam umsStudent);

    int deleteById(Integer sutudenId);
    List<UmsStudent> query(UmsStudentQueryParam loginRq);
}








