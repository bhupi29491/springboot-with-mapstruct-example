package com.bhupi.mapstruct.service;

import com.bhupi.mapstruct.dto.EmployeeDTO;
import com.bhupi.mapstruct.dto.EmployeeDetailsDTO;
import com.bhupi.mapstruct.entity.Employee;
import com.bhupi.mapstruct.mapper.EmployeeDetailsMapper;
import com.bhupi.mapstruct.mapper.EmployeeMapper;
import com.bhupi.mapstruct.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    EmployeeDetailsMapper employeeDetailsMapper;

    public Employee saveEmployee(EmployeeDTO employeeDTO) {
        return employeeRepository.save(employeeMapper.toEntity(employeeDTO));
    }

    public EmployeeDTO getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(employeeMapper::toDTO)
                .orElse(new EmployeeDTO());
    }

    public EmployeeDetailsDTO getEmployeeDetailsById(Long id) {
        return employeeRepository.findById(id)
                .map(emp -> employeeDetailsMapper.toEmployeeDetailsDTO(emp, emp.getDepartment()))
                .orElse(new EmployeeDetailsDTO());
    }
}
