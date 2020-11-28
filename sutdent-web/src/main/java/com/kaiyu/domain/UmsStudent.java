package com.kaiyu.domain;

import lombok.Data;

import java.util.Date;

/**
 * 学生表
 */
@Data
public class UmsStudent {
    /**
     * 学号
     */
    private String studentId;

    /**
     * 姓名
     */
    private String studentName;

    /**
     * 入学年份
     */
    private String studentYears;

    /**
     * 学院
     */
    private String studentAcademy;

    /**
     * 班级
     */
    private String studentClass;

    /**
     * 部门
     */
    private String studentDepartment;

    /**
     * 职位
     */
    private String studentPosition;

    /**
     * 手机号
     */
    private String studentPhone;

    /**
     * 出生年月
     */
    private Date studentBorn;

    /**
     * 新增时间
     */
    private Date createAt;

    /**
     * 更新时间
     */
    private Date updateAt;
}