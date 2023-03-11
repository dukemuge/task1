package com.pezesha.task.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer  transactionId;

    private long sourceAccountId;

    private long targetAccountId;

    private String targetOwnerName;

    private BigDecimal amount;

    private LocalDateTime initiationDate;

    private LocalDateTime completionDate;
}
