package com.bhupi.mapstruct.controller;

import com.bhupi.mapstruct.dto.EmployeeDTO;
import com.bhupi.mapstruct.dto.EmployeeDetailsDTO;
import com.bhupi.mapstruct.entity.Employee;
import com.bhupi.mapstruct.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.saveEmployee(employeeDTO));
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping("/employee-detail/{id}")
    public ResponseEntity<EmployeeDetailsDTO> getEmployeeDetailsById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeDetailsById(id));
    }
}
