package com.bhupi.mapstruct.dto;

import lombok.Data;

@Data
public class TransactionDTO {

    private String transactionId;

    private PaymentType paymentType;
}
