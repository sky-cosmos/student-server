package com.kaiyu.dto;


import lombok.Data;


/**
 * 查询接口
 */
@Data
public class UmsAdminQueryParam extends PageParam {
    private String username;
    private String nickName;
    private Integer status;
}
