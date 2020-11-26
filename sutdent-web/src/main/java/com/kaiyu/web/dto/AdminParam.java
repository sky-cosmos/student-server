package com.kaiyu.web.dto;

import com.kaiyu.mbg.domain.UmsAdmin;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AdminParam {
    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不可以为空")
    private String username;
    @ApiModelProperty(value="密码")
    @NotBlank(message = "密码不可以为空")
    private String password;
}
