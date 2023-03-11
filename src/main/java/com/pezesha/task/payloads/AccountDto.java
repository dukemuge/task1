package com.pezesha.task.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public  class AccountDto {
    private Integer id;

    @NotBlank(message = "Account number is mandatory")
    private String accountNumber;
    private LocalDateTime dateOfCreation;
    @NotEmpty
    @Size(min = 0,message = "minimum amount in the account must be zero")
    private BigDecimal currentBalance;

}