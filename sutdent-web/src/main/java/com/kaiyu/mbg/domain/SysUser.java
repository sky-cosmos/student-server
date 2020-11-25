package com.kaiyu.mbg.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@ApiModel(value = "com-kaiyu-mbg-domain-SysUser")
@Data
@Table(name = "sys_user")
public class SysUser {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(value = "")
    private Long userId;

    /**
     * 用户名
     */
    @Column(name = "username")
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 密码
     */
    @Column(name = "`password`")
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 盐
     */
    @Column(name = "salt")
    @ApiModelProperty(value = "盐")
    private String salt;

    /**
     * 邮箱
     */
    @Column(name = "email")
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 手机号
     */
    @Column(name = "mobile")
    @ApiModelProperty(value = "手机号")
    private String mobile;

    /**
     * 状态  0：禁用   1：正常
     */
    @Column(name = "`status`")
    @ApiModelProperty(value = "状态  0：禁用   1：正常")
    private Byte status;

    /**
     * 创建者ID
     */
    @Column(name = "create_user_id")
    @ApiModelProperty(value = "创建者ID")
    private Long createUserId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}