package com.semicolon.springBank.dto.customerRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class WithdrawalRequest {

    private String accountNumber;
    private int amount;
    private String password;
}
