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

    @NotBlank(message = "用戶名不可為空")
    private String username;

    @NotBlank(message = "密碼不可為空")
    private String password;

    /**
     * 头像
     */
    private String icon;

    /**
     * 邮箱
     */
    @Email(message = "email格式不正確")
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
    @NotNull(message = "狀態不可爲空")
    private Integer status;
}
