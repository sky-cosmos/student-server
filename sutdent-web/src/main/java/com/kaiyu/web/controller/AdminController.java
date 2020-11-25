package com.kaiyu.web.controller;

import com.kaiyu.common.api.CommonResult;
import com.kaiyu.mbg.domain.SysUser;
import com.kaiyu.web.service.SysUserService;
import com.kaiyu.web.dto.AdminParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("/admin")
public class AdminController {
    @Autowired
    SysUserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public CommonResult<SysUser> login(@Valid @RequestBody AdminParam loginRq){
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(loginRq,sysUser);
        SysUser user= userService.login(sysUser);
        if(user!=null){
            return CommonResult.success(user);
        }else{
            return CommonResult.failed();
        }
    }
    @GetMapping("/loginfo")
    @ApiOperation("获取登录信息")
    public CommonResult<SysUser> getLogInfo(){
        return null;
    }
 }
