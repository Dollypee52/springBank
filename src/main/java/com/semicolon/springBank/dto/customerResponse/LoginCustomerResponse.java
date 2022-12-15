package com.semicolon.springBank.dto.customerResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginCustomerResponse {

    private String message;
    private String firstName;
    private String lastName;
    private String accountNumber;
    private int balance;
}
