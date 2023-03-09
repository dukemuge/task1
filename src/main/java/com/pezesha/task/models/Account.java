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
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    private String accountName;
    private LocalDateTime dateOfCreation;
    private BigDecimal currentBalance;


}
