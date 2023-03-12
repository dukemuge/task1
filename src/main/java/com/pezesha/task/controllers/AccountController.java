package com.pezesha.task.controllers;

import com.pezesha.task.payloads.AccountDto;
import com.pezesha.task.services.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 *
 * @author Duke Muge
 */
@RestController
@RequestMapping("api/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;


    /**
     * Gets the details  of the account with id accountId.
     *
     * @param accountId - represents the Id of the Account.
     * @return ResponseEntity with Json value of account value.
     */
    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDto> getAccountDetails(@PathVariable Integer accountId){
        var accountDto = this.accountService.getAccountById(accountId);
        return ResponseEntity.ok(accountDto);
    }

    /**
     * creates  account in the database.
     *
     * @param accountDto - represents the body of the AccountDto.
     * @return valid Http.status oK if account is successfully persisted
     */    @PostMapping("")
    public ResponseEntity<AccountDto>  createNewAccount(@Valid @RequestBody AccountDto accountDto){
        AccountDto createdAccountDto = this.accountService.createAccount(accountDto);
        return new ResponseEntity<>(createdAccountDto, HttpStatus.CREATED);
    }




}
