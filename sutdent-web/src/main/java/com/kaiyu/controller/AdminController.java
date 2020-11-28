package com.kaiyu.controller;

import com.github.pagehelper.PageInfo;
import com.kaiyu.common.api.CommonPage;
import com.kaiyu.common.api.CommonResult;
import com.kaiyu.domain.UmsAdmin;
import com.kaiyu.dto.AdminParam;
import com.kaiyu.dto.UmsAdminParam;
import com.kaiyu.dto.UmsAdminQueryParam;
import com.kaiyu.service.UmsAdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v2/admin")
public class AdminController {
    public static final String SESSIONKEY="sessionKey";
    @Autowired
    UmsAdminService adminService;

    @PostMapping("/insert")
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
    public CommonResult update(@Valid @RequestBody UmsAdmin admin){
        int insertt = adminService.update(admin);
        if(insertt>0){
            return CommonResult.success("");
        }else{
            return CommonResult.failed();
        }
    }
    @DeleteMapping("/delete/{id}")
    public CommonResult delete(@PathVariable("id") Long adminId){
        int insertt = adminService.delete(adminId);
        if(insertt>0){
            return CommonResult.success("");
        }else{
            return CommonResult.failed();
        }
    }

    @PostMapping("/list")
    public CommonResult<CommonPage> list(@Valid @RequestBody PageInfo loginRq){
        List<UmsAdmin> user= adminService.list(loginRq);
       return CommonResult.success(CommonPage.restPage(user));
    }
    @PostMapping("/listQuery")
    public CommonResult<CommonPage> list(@Valid @RequestBody UmsAdminQueryParam  loginRq){
        List<UmsAdmin> user= adminService.query(loginRq);
        return CommonResult.success(CommonPage.restPage(user));
    }

    @PostMapping("/login")
    public CommonResult<UmsAdmin> login(@Valid @RequestBody AdminParam loginRq,HttpSession session){
        UmsAdmin user= adminService.login(loginRq);
        if(user!=null){
            session.setAttribute(SESSIONKEY,user);
            return CommonResult.success(user);
        }else{
            return CommonResult.failed();
        }
    }
    @GetMapping("/loginfo")
    public CommonResult<UmsAdmin> getLogInfo(HttpSession session){
        UmsAdmin umsAdmin = (UmsAdmin) session.getAttribute(SESSIONKEY);
        if(umsAdmin==null){
            return CommonResult.failed("not login");
        }
        return CommonResult.success(umsAdmin);
    }
 }
