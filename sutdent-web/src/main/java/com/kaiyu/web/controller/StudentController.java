package com.kaiyu.web.controller;

import java.util.List;

import cn.hutool.extra.spring.SpringUtil;
import com.kaiyu.common.api.CommonPage;
import com.kaiyu.common.api.CommonResult;
import com.kaiyu.mbg.domain.UmsStudent;
import com.kaiyu.web.dto.PageParam;
import com.kaiyu.web.dto.UmsStudentParam;
import com.kaiyu.web.service.UmsStudentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController("/student")
public class StudentController {
    @Autowired
    UmsStudentService umsStudentService;

    @ApiOperation("用户新增")
    @PostMapping("/insert")
    public CommonResult insert(@RequestBody UmsStudentParam umsStudent) {
        UmsStudent umsStudent1 = new UmsStudent();
        BeanUtils.copyProperties(umsStudent,umsStudent1);
        int result = umsStudentService.insert(umsStudent1);
        if(result>0){
            return CommonResult.success("");
        }else{
            return CommonResult.failed();
        }
    }

    @ApiOperation("用户修改")
    @PostMapping("/update")
    public CommonResult update(@RequestBody UmsStudentParam umsStudent) {
        UmsStudent umsStudent1 = new UmsStudent();
        BeanUtils.copyProperties(umsStudent,umsStudent1);
        int result = umsStudentService.update(umsStudent1);
        if(result==1){
            return CommonResult.success("");
        }else{
            return CommonResult.failed("修改失败");
        }
    }

    @ApiOperation("用户删除")
    @PostMapping("/delete/{id}")
    public CommonResult insert(@PathVariable("id") Integer sutudenId, HttpSession session) {
        int result = umsStudentService.deleteById(sutudenId);
        if(result==1){
            return CommonResult.success("");
        }else{
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页查询")
    @PostMapping("/list")
    public CommonResult<CommonPage> list(@RequestBody PageParam pageParam) {
        List<UmsStudent> result = umsStudentService.list(pageParam);
        return CommonResult.success(CommonPage.restPage(result));
    }

    @ApiOperation("根据用户Id查询")
    @GetMapping("/listOne/{id}")
    public CommonResult<UmsStudent> list(@PathVariable("id") Integer umsStudentId) {
        UmsStudent result = umsStudentService.listById(umsStudentId);
        return CommonResult.success(result);
    }

}
