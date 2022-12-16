package com.semicolon.springBank.dto.customerRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TransferRequest {

    private String senderAccountNumber;
    private String password;
    private String receiverAccountNumber;
    private int amount;
}
