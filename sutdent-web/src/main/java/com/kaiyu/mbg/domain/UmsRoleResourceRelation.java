package com.kaiyu.mbg.domain;

import javax.persistence.*;
import lombok.Data;

/**
 * 后台角色资源关系表
 */
@Data
@Table(name = "ums_role_resource_relation")
public class UmsRoleResourceRelation {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 角色No
     */
    @Column(name = "role_no")
    private String roleNo;

    /**
     * 资源ID
     */
    @Column(name = "resource_id")
    private Long resourceId;
}