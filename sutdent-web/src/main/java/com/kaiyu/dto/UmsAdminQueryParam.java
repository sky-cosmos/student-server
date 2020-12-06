package com.kaiyu.dto;


import lombok.Data;


/**
 * 查询接口
 * 支持查询的参数有这三个
 */
@Data
public class UmsAdminQueryParam extends PageParam {
    private String  username;
    private String  nickName;
    private Integer status;
}
