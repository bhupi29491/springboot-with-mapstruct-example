package com.bhupi.mapstruct.dto;

import lombok.Data;

@Data
public class EmployeeDTO {

    private Long empId;
    private String empName;
    private String email;
    private Float salary;
    private DepartmentDTO departmentDTO;
}
