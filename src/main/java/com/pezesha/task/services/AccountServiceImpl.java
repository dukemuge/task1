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

    /**
     * method to convert account payloads to Account model using ModelMapper library.
     *
     * @param accountDto - represents the AccountDto of the Account.
     * @return Returns the Account Entity.
     */
    private Account dtoToAccount(AccountDto accountDto){
        Account account = this.modelMapper.map(accountDto,Account.class);
        return  account;
    }



    /**
     * method to convert Account Entity to AccountDto model using ModelMapper library.
     *
     * @param account - represents Account Entity to be converted.
     * @return Returns the Account Entity.
     */

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
