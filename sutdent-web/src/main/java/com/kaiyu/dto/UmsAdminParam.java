package com.kaiyu.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author riversky
 * @date 2020/11/26
 **/
@Data
public class UmsAdminParam {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 头像
     */
    private String icon;

    /**
     * 邮箱
     */
    @Email(message = "email格式不正确")
    private String email;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 备注信息
     */
    private String note;



    /**
     * 帐号启用状态：0->禁用；1->启用
     */
    @NotNull(message = "状态不能为空")
    private Integer status;
}
