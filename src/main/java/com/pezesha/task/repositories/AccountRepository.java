package com.pezesha.task.repositories;

import com.pezesha.task.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository  extends JpaRepository<Account,Integer> {
    Optional<Account> findByAccountNumber(String accountNumber);

}
