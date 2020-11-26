package com.kaiyu.web.dto;

import com.kaiyu.mbg.domain.UmsAdmin;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author riversky
 * @date 2020/11/26
 **/
@Data
public class UmsAdminParam {

    @NotBlank(message = "用戶名不可為空")
    private String username;

    @Column(name = "`password`")
    @NotBlank(message = "密碼不可為空")
    private String password;

    /**
     * 头像
     */
    @Column(name = "icon")
    private String icon;

    /**
     * 邮箱
     */
    @Column(name = "email")
    @Email(message = "email格式不正確")
    private String email;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 备注信息
     */
    @Column(name = "note")
    private String note;



    /**
     * 帐号启用状态：0->禁用；1->启用
     */
    @Column(name = "`status`")
    @NotNull(message = "狀態不可爲空")
    private Integer status;
}
