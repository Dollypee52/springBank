package com.semicolon.springBank.dto.customerResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RegisterCustomerResponse {


    private String message;
    private String accountNumber;
}
