package com.kaiyu.mbg.domain;

import javax.persistence.*;
import lombok.Data;

/**
 * 后台用户和角色关系表
 */
@Data
@Table(name = "ums_admin_role_relation")
public class UmsAdminRoleRelation {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "admin_id")
    private Long adminId;

    @Column(name = "role_id")
    private Long roleId;
}