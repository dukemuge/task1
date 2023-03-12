package com.pezesha.task.controllers;

import com.pezesha.task.payloads.TransactionRequest;
import com.pezesha.task.repositories.TransactionRepository;
import com.pezesha.task.services.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
    private TransactionRepository transactionRepository;
    private TransactionService  transactionService;


    @Autowired
    public TransactionController(TransactionRepository transactionRepository, TransactionService transactionService) {
        this.transactionRepository = transactionRepository;
        this.transactionService = transactionService;
    }

    @PostMapping(value = "/transfers",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> makeTransfer(
            @Valid @RequestBody TransactionRequest transactionResponse) {
            boolean isComplete = transactionService.makeTransfer(transactionResponse);
            return new ResponseEntity<>(isComplete, HttpStatus.OK);
        }
    }



