package com.semicolon.springBank.dto.customerResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class WithdrawalResponse {

    private String message;
    private int balance;
}
