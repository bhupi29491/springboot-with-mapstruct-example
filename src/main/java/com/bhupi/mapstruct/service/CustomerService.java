package com.bhupi.mapstruct.service;

import com.bhupi.mapstruct.dto.CustomerDTO;
import com.bhupi.mapstruct.entity.Customer;
import com.bhupi.mapstruct.mapper.CustomerMapper;
import com.bhupi.mapstruct.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerMapper customerMapper;

    public Customer saveCustomer(CustomerDTO customerDTO) {
        return customerRepository.save(customerMapper.toEntity(customerDTO));
    }

    public CustomerDTO getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::toDTO)
                .orElse(new CustomerDTO());
    }

}
