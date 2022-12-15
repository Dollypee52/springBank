package com.semicolon.springBank.dto.customerRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CheckBalanceRequest {
    private String password;
    private String accountNumber;
}
