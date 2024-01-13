package com.bhupi.mapstruct.controller;

import com.bhupi.mapstruct.dto.TransactionDTO;
import com.bhupi.mapstruct.dto.TransactionViewDTO;
import com.bhupi.mapstruct.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transaction")
    public ResponseEntity<TransactionViewDTO> getTransactionDetails(@RequestBody TransactionDTO transactionDTO) {
        return ResponseEntity.ok(transactionService.getTransactionDetails(transactionDTO));
    }
}
