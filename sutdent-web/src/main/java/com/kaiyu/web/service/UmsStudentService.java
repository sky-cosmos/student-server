package com.kaiyu.web.service;

import com.kaiyu.mbg.domain.UmsStudent;
import com.kaiyu.web.dto.PageParam;

import java.util.List;

public interface UmsStudentService {


    int insert(UmsStudent umsStudent);

    int update(UmsStudent umsStudent);

    UmsStudent listById(Integer umsStudentId);

    List<UmsStudent> list(PageParam umsStudent);

    int deleteById(Integer sutudenId);
}








