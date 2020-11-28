package com.kaiyu.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AdminParam {
    @NotBlank(message = "用户名不可以为空")
    private String username;
    @NotBlank(message = "密码不可以为空")
    private String password;
}
