package com.kaiyu.web.service.impl;

import com.github.pagehelper.PageHelper;import com.kaiyu.mbg.domain.UmsStudent;
import com.kaiyu.web.dto.PageParam;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.kaiyu.mbg.mapper.UmsStudentMapper;
import com.kaiyu.web.service.UmsStudentService;

import java.util.List;

@Service
public class UmsStudentServiceImpl implements UmsStudentService {

    @Resource
    private UmsStudentMapper umsStudentMapper;

    @Override
    public int insert(UmsStudent umsStudent) {
        return umsStudentMapper.insert(umsStudent);
    }
/**那个不用单引号吗？？？？？数据库里没有更新。。。*/
    @Override
    public int update(UmsStudent umsStudent) {
        return umsStudentMapper.updateByPrimaryKey(umsStudent);
    }

    @Override
    public UmsStudent listById(Integer umsStudentId) {
        return umsStudentMapper.selectByPrimaryKey(umsStudentId);
    }

    @Override
    public List<UmsStudent> list(PageParam pageParam) {
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
        return umsStudentMapper.selectAll();
    }

    @Override
    public int deleteById(Integer sutudenId) {
        return umsStudentMapper.deleteByPrimaryKey(sutudenId);
    }
}






