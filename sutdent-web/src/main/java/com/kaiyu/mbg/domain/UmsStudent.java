package com.kaiyu.mbg.domain;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

/**
 * 学生表
 */
@Data
@Table(name = "ums_student")
public class UmsStudent {
    /**
     * 学号
     */
    @Id
    @Column(name = "student_id")
    private String studentId;

    /**
     * 姓名
     */
    @Column(name = "student_name")
    private String studentName;

    /**
     * 入学年份
     */
    @Column(name = "student_years")
    private String studentYears;

    /**
     * 学院
     */
    @Column(name = "student_academy")
    private String studentAcademy;

    /**
     * 班级
     */
    @Column(name = "student_class")
    private String studentClass;

    /**
     * 部门
     */
    @Column(name = "student_department")
    private String studentDepartment;

    /**
     * 职位
     */
    @Column(name = "student_position")
    private String studentPosition;

    /**
     * 手机号
     */
    @Column(name = "student_phone")
    private String studentPhone;

    /**
     * 出生年月
     */
    @Column(name = "student_born")
    private Date studentBorn;

    /**
     * 新增时间
     */
    @Column(name = "create_at")
    private Date createAt;

    /**
     * 更新时间
     */
    @Column(name = "update_at")
    private Date updateAt;
}