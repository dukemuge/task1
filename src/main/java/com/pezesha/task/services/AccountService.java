package com.pezesha.task.services;

import com.pezesha.task.payloads.AccountDto;

public interface AccountService {
    AccountDto createAccount(AccountDto account);
    AccountDto getAccountById(Integer accountId);
}
