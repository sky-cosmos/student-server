package com.kaiyu.web.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.kaiyu.mbg.mapper.UmsResourceMapper;
import com.kaiyu.web.service.UmsResourceService;
@Service
public class UmsResourceServiceImpl implements UmsResourceService{

    @Resource
    private UmsResourceMapper umsResourceMapper;

}
