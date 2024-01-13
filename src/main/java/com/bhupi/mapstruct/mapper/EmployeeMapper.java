package com.bhupi.mapstruct.mapper;

import com.bhupi.mapstruct.dto.EmployeeDTO;
import com.bhupi.mapstruct.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DepartmentMapper.class})
public interface EmployeeMapper {

    @Mapping(source = "empId", target = "id")
    @Mapping(source = "empName", target = "name")
//    @Mapping(source = "departmentName", target = "department.deptName")
    @Mapping(source = "departmentDTO", target = "department")
    Employee toEntity(EmployeeDTO employeeDTO);

    @Mapping(source = "id", target = "empId")
    @Mapping(source = "name", target = "empName")
//    @Mapping(source = "department.deptName", target = "departmentName")
    @Mapping(source = "department", target = "departmentDTO")
    EmployeeDTO toDTO(Employee employee);
}
