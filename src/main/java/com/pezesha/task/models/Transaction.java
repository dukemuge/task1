package com.pezesha.task.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Transaction {
    @Id
    @GeneratedValue
    private  Long  transactionId;
    private String accountNumber;
    private BigDecimal transactionAmount;
    private LocalDateTime dateOfTransaction;
}
