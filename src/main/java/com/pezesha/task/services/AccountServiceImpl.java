package com.pezesha.task.services;

import com.pezesha.task.exceptions.ResourceNotFoundException;
import com.pezesha.task.models.Account;
import com.pezesha.task.payloads.AccountDto;
import com.pezesha.task.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountServiceImpl  implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ModelMapper modelMapper;

    private Account dtoToAccount(AccountDto accountDto){
        Account account = this.modelMapper.map(accountDto,Account.class);
        return  account;
    }

    public AccountDto accountToDto(Account account){
        AccountDto accountDto = this.modelMapper.map(account, AccountDto.class);
        return accountDto;
    }



    @Override
    public AccountDto createAccount(   AccountDto accountDto) {
        Account account  = this.dtoToAccount(accountDto);
        account.setDateOfCreation(LocalDateTime.now());
        account.setCurrentBalance(BigDecimal.ZERO);
        Account savedAccount = this.accountRepository.save(account);
        return this.accountToDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Integer userId) {
        Account account  = this.accountRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","Id",userId));
        return this.accountToDto(account);
    }

}
