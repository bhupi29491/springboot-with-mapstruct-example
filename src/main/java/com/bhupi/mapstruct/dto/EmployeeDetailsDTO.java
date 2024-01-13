package com.bhupi.mapstruct.dto;

import lombok.Data;

@Data
public class EmployeeDetailsDTO {

    private Long empId;
    private String empName;
    private String email;
    private Float salary;
    private String deptId;
    private String deptName;
}
