package com.pezesha.task.services;


import com.pezesha.task.constants.ACTION;
import com.pezesha.task.models.Account;
import com.pezesha.task.models.Transaction;
import com.pezesha.task.payloads.TransactionRequest;
import com.pezesha.task.repositories.AccountRepository;
import com.pezesha.task.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public boolean isAmountAvailable(BigDecimal amount, BigDecimal accountBalance) {
        var result  = accountBalance.subtract(amount);
        return result.compareTo(BigDecimal.ZERO) > 0;
    }

    public void updateAccountBalance(Account account, BigDecimal amount, ACTION action) {
        if (action == ACTION.WITHDRAW) {
            account.setCurrentBalance((account.getCurrentBalance().subtract(amount)));
        } else if (action == ACTION.DEPOSIT) {
            account.setCurrentBalance((account.getCurrentBalance().add(amount)));
        }
        accountRepository.save(account);
    }

    public boolean makeTransfer(TransactionRequest transactionRequest ) {
        String sourceAccountNumber = transactionRequest.getSourceAccount().getAccountNumber();
        Optional<Account> sourceAccount = accountRepository.findByAccountNumber(sourceAccountNumber);

        String targetAccountNumber = transactionRequest.getTargetAccount().getAccountNumber();
        Optional<Account> targetAccount = accountRepository.findByAccountNumber(targetAccountNumber);

        if (sourceAccount.isPresent() && targetAccount.isPresent()) {
            if (isAmountAvailable(transactionRequest.getAmount(), sourceAccount.get().getCurrentBalance())) {
                var transaction = new Transaction();

                transaction.setAmount(transactionRequest.getAmount());
                transaction.setSourceAccountId(sourceAccount.get().getId());
                transaction.setTargetAccountId(targetAccount.get().getId());
                transaction.setInitiationDate(LocalDateTime.now());
                transaction.setCompletionDate(LocalDateTime.now());

                updateAccountBalance(sourceAccount.get(), transactionRequest.getAmount(), ACTION.WITHDRAW);
                transactionRepository.save(transaction);

                return true;
            }
        }
        return false;
    }







}