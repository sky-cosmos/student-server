package com.kaiyu.dto;

import lombok.Data;

@Data
public class UmsStudentQueryParam extends PageParam {
    private String  studentName;
    private String  studentPosition;
    private String  studentDepartment;
}
