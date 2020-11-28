package com.kaiyu.service;

import com.kaiyu.domain.UmsStudent;
import com.kaiyu.dto.PageParam;
import com.kaiyu.dto.UmsStudentParam;

import java.util.List;

public interface UmsStudentService {


    int insert(UmsStudent umsStudent);

    int update(UmsStudentParam umsStudent);

    UmsStudent listById(Integer umsStudentId);

    List<UmsStudent> list(PageParam umsStudent);

    int deleteById(Integer sutudenId);
}








