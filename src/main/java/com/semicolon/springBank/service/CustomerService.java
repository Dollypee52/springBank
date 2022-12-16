package com.semicolon.springBank.service;

import com.semicolon.springBank.dto.customerRequest.DepositRequest;
import com.semicolon.springBank.dto.customerRequest.LoginCustomerRequest;
import com.semicolon.springBank.dto.customerRequest.RegisterCustomerRequest;
import com.semicolon.springBank.dto.customerRequest.TransferRequest;
import com.semicolon.springBank.dto.customerResponse.DepositResponse;
import com.semicolon.springBank.dto.customerResponse.LoginCustomerResponse;
import com.semicolon.springBank.dto.customerResponse.RegisterCustomerResponse;
import com.semicolon.springBank.dto.customerResponse.TransferResponse;

public interface CustomerService {

    LoginCustomerResponse loginCustomerRequest(LoginCustomerRequest loginCustomerRequest);
    RegisterCustomerResponse createAccount(RegisterCustomerRequest request);
    DepositResponse deposit(DepositRequest depositRequest);
    TransferResponse transfer(TransferRequest transfer);
}
