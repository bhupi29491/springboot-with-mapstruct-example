package com.bhupi.mapstruct.dto;

import lombok.Data;

@Data
public class CustomerDTO {

    private Long customerId;
    private String customerName;
    private String countryName;
    private String registrationDate;
}
