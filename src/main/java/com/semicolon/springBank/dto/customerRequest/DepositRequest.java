package com.semicolon.springBank.dto.customerRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DepositRequest {

    private String firstName;
    private String lastName;
    private String accountNumber;
    private int amount;
}
