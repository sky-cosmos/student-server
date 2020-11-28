package com.kaiyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.kaiyu.dao.UmsStudentDao;
import com.kaiyu.domain.UmsStudent;
import com.kaiyu.dto.PageParam;
import com.kaiyu.dto.UmsStudentParam;
import com.kaiyu.service.UmsStudentService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import java.util.List;

@Service
public class UmsStudentServiceImpl implements UmsStudentService {

    @Resource
    private UmsStudentDao umsStudentMapper;

    @Override
    public int insert(UmsStudent umsStudent) {
        return umsStudentMapper.insert(umsStudent);
    }

    @Override
    public int update(UmsStudentParam umsStudent) {
        return umsStudentMapper.updateByPrimaryKey(umsStudent);
    }

    @Override
    public UmsStudent listById(Integer umsStudentId) {
        return umsStudentMapper.selectByPrimaryKey(umsStudentId);
    }

    @Override
    public List<UmsStudent> list(PageParam umsStudent) {
        PageHelper.startPage(umsStudent.getPageNum(),umsStudent.getPageSize());
        return umsStudentMapper.selectAll();
    }

    @Override
    public int deleteById(Integer sutudenId) {
        return umsStudentMapper.deleteByPrimaryKey(sutudenId);
    }
}
