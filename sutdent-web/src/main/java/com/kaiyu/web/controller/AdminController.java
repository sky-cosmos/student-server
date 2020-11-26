package com.kaiyu.web.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.kaiyu.common.api.CommonPage;
import com.kaiyu.common.api.CommonResult;
import com.kaiyu.mbg.domain.UmsAdmin;
import com.kaiyu.web.dto.AdminParam;
import com.kaiyu.web.dto.UmsAdminParam;
import com.kaiyu.web.service.UmsAdminService;
import com.kaiyu.web.utils.JwtTokenUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v2/admin")
public class AdminController {
    public static final String userId="userId";
    public static final String userName="username";
    @Autowired
    UmsAdminService adminService;
    @Autowired
    JwtTokenUtils tokenUtils;

    @PostMapping("/insert")
    @ApiOperation(value = "新增")
    public CommonResult insert(@Valid @RequestBody UmsAdminParam admin){
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(admin,umsAdmin);
        int insertt = adminService.insertt(umsAdmin);
        if(insertt>0){
            return CommonResult.success("");
        }else{
            return CommonResult.failed();
        }
    }
    @PutMapping("/update")
    @ApiOperation(value = "更新")
    public CommonResult update(@Valid @RequestBody UmsAdmin admin){
        int insertt = adminService.update(admin);
        if(insertt>0){
            return CommonResult.success("");
        }else{
            return CommonResult.failed();
        }
    }
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除")
    public CommonResult delete(@PathVariable("id") Long adminId){
        int insertt = adminService.delete(adminId);
        if(insertt>0){
            return CommonResult.success("");
        }else{
            return CommonResult.failed();
        }
    }

    @PostMapping("/list")
    @ApiOperation(value = "查询")
    public CommonResult<CommonPage> list(@Valid @RequestBody PageInfo loginRq){
        List<UmsAdmin> user= adminService.list(loginRq);
       return CommonResult.success(CommonPage.restPage(user));
    }

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public CommonResult<String> login(@Valid @RequestBody AdminParam loginRq){
        UmsAdmin sysUser = new UmsAdmin();
        BeanUtils.copyProperties(loginRq,sysUser);
        UmsAdmin user= adminService.login(sysUser);
        if(user!=null){
            String s = tokenUtils.generateToken(user);
            return CommonResult.success(s);
        }else{
            return CommonResult.failed();
        }
    }
    @GetMapping("/loginfo")
    @ApiOperation("获取登录信息")
    public CommonResult<UmsAdmin> getLogInfo(HttpServletRequest request){
        UmsAdmin umsAdmin = (UmsAdmin) request.getAttribute("umsAdmin");
        if(umsAdmin==null){
            return CommonResult.failed("not login");
        }
        return CommonResult.success(umsAdmin);
    }
 }
