package com.bhupi.mapstruct.controller;

import com.bhupi.mapstruct.dto.CustomerDTO;
import com.bhupi.mapstruct.entity.Customer;
import com.bhupi.mapstruct.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/customer")
    public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.saveCustomer(customerDTO));
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

}
