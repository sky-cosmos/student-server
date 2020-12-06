package com.kaiyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaiyu.dao.UmsStudentDao;
import com.kaiyu.domain.UmsAdmin;
import com.kaiyu.domain.UmsStudent;
import com.kaiyu.dto.PageParam;
import com.kaiyu.dto.UmsStudentParam;
import com.kaiyu.dto.UmsStudentQueryParam;
import com.kaiyu.service.UmsStudentService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import java.util.List;

@Service
public class UmsStudentServiceImpl implements UmsStudentService {
    @Resource
    private UmsStudentDao umsStudentMapper;


    public List<UmsStudent> list(UmsStudentQueryParam loginRq) {
        PageHelper.startPage(loginRq.getPageNum(),loginRq.getPageSize());
        return umsStudentMapper.likeQuery(loginRq);
    }

    @Override
    public List<UmsStudent> list(PageInfo loginRq) {
        return null;
    }

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

    @Override
    public List<UmsStudent> query(UmsStudentQueryParam loginRq) {
        //有个工具直接可以实现sql分页
        PageHelper.startPage(loginRq.getPageNum(),loginRq.getPageSize());
        return umsStudentMapper.likeQuery(loginRq);
    }

}
