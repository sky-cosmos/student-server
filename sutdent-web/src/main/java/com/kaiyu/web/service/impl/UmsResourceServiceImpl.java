package com.kaiyu.web.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.kaiyu.mbg.mapper.UmsResourceMapper;

@Service
public class UmsResourceServiceImpl {

    @Resource
    private UmsResourceMapper umsResourceMapper;

}
