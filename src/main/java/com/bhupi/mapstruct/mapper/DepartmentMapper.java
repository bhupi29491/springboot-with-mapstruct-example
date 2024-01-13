package com.bhupi.mapstruct.mapper;

import com.bhupi.mapstruct.dto.DepartmentDTO;
import com.bhupi.mapstruct.entity.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    
    Department toEntity(DepartmentDTO departmentDTO);

    DepartmentDTO toDTO(Department department);
}
