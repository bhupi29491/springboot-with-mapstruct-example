package com.bhupi.mapstruct.service;

import com.bhupi.mapstruct.dto.TransactionDTO;
import com.bhupi.mapstruct.dto.TransactionViewDTO;
import com.bhupi.mapstruct.mapper.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionMapper transactionMapper;

    public TransactionViewDTO getTransactionDetails(TransactionDTO transactionDTO) {
        return transactionMapper.toViewDTO(transactionDTO);
    }
}
