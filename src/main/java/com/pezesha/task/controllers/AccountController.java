package com.pezesha.task.controllers;

import com.pezesha.task.payloads.AccountDto;
import com.pezesha.task.services.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDto> getAccountDetails(@PathVariable Integer accountId){
        var accountDto = this.accountService.getAccountById(accountId);
        return ResponseEntity.ok(accountDto);
    }

    //POST -create account
    @PostMapping("")
    public ResponseEntity<AccountDto>  createNewAccount(@Valid @RequestBody AccountDto accountDto){
        AccountDto createdAccountDto = this.accountService.createAccount(accountDto);
        return new ResponseEntity<>(createdAccountDto, HttpStatus.CREATED);
    }




}
