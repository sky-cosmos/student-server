package com.kaiyu.mbg.domain;

import javax.persistence.*;
import lombok.Data;

/**
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)
 */
@Data
@Table(name = "ums_admin_permission_relation")
public class UmsAdminPermissionRelation {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "admin_id")
    private Long adminId;

    @Column(name = "permission_id")
    private Long permissionId;

    @Column(name = "`type`")
    private Integer type;
}