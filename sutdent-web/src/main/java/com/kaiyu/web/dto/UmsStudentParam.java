package com.kaiyu.web.dto;

import com.kaiyu.mbg.domain.UmsStudent;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class UmsStudentParam {
    /**
     * 学号
     */
    @ApiModelProperty(value = "学号")
    @NotBlank(message = "学号不可为空")
    private String studentId;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    @NotBlank(message = "姓名不可为空")
    private String studentName;

    /**
     * 入学年份
     */
    @ApiModelProperty(value = "入学年份")
    @NotBlank(message = "入学年份不可以为空")
    private String studentYears;

    /**
     * 学院
     */
    @ApiModelProperty(value = "学院")
    @NotBlank(message = "学院不可以为空")
    private String studentAcademy;

    /**
     * 班级
     */
    @ApiModelProperty(value = "班级")
    @NotBlank(message = "班级不可以为空")
    private String studentClass;

    /**
     * 部门
     */
    @ApiModelProperty(value = "部门")
    @NotBlank(message = "部门不可以为空")
    private String studentDepartment;

    /**
     * 职位
     */
    @ApiModelProperty(value = "职位")
    private String studentPosition;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String studentPhone;

    /**
     * 出生年月
     */
    @ApiModelProperty(value = "出生年月")
    @NotNull(message = "出生年月不可为空")
    private Date studentBorn;
}
