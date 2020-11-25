package com.kaiyu.mbg.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@ApiModel(value = "com-kaiyu-mbg-domain-UmsStudent")
@Data
@Table(name = "ums_student")
public class UmsStudent {
    /**
     * 学号
     */
    @Id
    @Column(name = "student_id")
    @ApiModelProperty(value = "学号")
    private String studentId;

    /**
     * 姓名
     */
    @Column(name = "student_name")
    @ApiModelProperty(value = "姓名")
    private String studentName;

    /**
     * 入学年份
     */
    @Column(name = "student_years")
    @ApiModelProperty(value = "入学年份")
    private String studentYears;

    /**
     * 学院
     */
    @Column(name = "student_academy")
    @ApiModelProperty(value = "学院")
    private String studentAcademy;

    /**
     * 班级
     */
    @Column(name = "student_class")
    @ApiModelProperty(value = "班级")
    private String studentClass;

    /**
     * 部门
     */
    @Column(name = "student_department")
    @ApiModelProperty(value = "部门")
    private String studentDepartment;

    /**
     * 职位
     */
    @Column(name = "student_position")
    @ApiModelProperty(value = "职位")
    private String studentPosition;

    /**
     * 手机号
     */
    @Column(name = "student_phone")
    @ApiModelProperty(value = "手机号")
    private String studentPhone;

    /**
     * 出生年月
     */
    @Column(name = "student_born")
    @ApiModelProperty(value = "出生年月")
    private Date studentBorn;

    /**
     * 新增时间
     */
    @Column(name = "create_at")
    @ApiModelProperty(value = "新增时间")
    private Date createAt;

    /**
     * 更新时间
     */
    @Column(name = "update_at")
    @ApiModelProperty(value = "更新时间")
    private Date updateAt;
}