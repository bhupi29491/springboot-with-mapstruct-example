package com.bhupi.mapstruct.mapper;

import com.bhupi.mapstruct.dto.CustomerDTO;
import com.bhupi.mapstruct.entity.Customer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;


@Mapper(componentModel = "spring", imports = {LocalDate.class})
public interface CustomerMapper {

    @Mapping(source = "customerId", target = "id", ignore = true) // This will not be Mapped
    @Mapping(source = "customerName", target = "name")
    @Mapping(source = "countryName", target = "country", defaultValue = "India")
    @Mapping(source = "registrationDate", target = "registrationDate", dateFormat = "dd/MM/yyy", defaultExpression =
            "java(LocalDate.now())")
    @Mapping(target = "type", constant = "New")
    Customer toEntity(CustomerDTO customerDTO);

    //    @Mapping(source = "id", target = "customerId")
//    @Mapping(source = "name", target = "customerName")
//    @Mapping(source = "country", target = "countryName")
//    @Mapping(source = "registrationDate", target = "registrationDate", dateFormat = "dd/MM/yyy")
    @InheritInverseConfiguration
    @Mapping(source = "id", target = "customerId")
    CustomerDTO toDTO(Customer customer);
}
