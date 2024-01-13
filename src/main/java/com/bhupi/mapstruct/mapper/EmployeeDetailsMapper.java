package com.bhupi.mapstruct.mapper;

import com.bhupi.mapstruct.dto.EmployeeDetailsDTO;
import com.bhupi.mapstruct.entity.Department;
import com.bhupi.mapstruct.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeDetailsMapper {

    @Mapping(source = "employee.id ", target = "empId")
    @Mapping(source = "employee.name", target = "empName")
    @Mapping(source = "department.id", target = "deptId")
    @Mapping(source = "department.deptName", target = "deptName")
    EmployeeDetailsDTO toEmployeeDetailsDTO(Employee employee, Department department);
}
