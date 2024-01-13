package com.bhupi.mapstruct.dto;

import lombok.Data;

@Data
public class OrderDTO {

    private Long id;

    private String orderAmount;

    private String description;

    private String orderDate;

    private String orderStatus;

    private Integer quantity;

    private Float sum;
}
