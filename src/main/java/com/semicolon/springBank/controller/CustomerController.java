package com.semicolon.springBank.controller;

import com.semicolon.springBank.dto.customerRequest.DepositRequest;
import com.semicolon.springBank.dto.customerRequest.LoginCustomerRequest;
import com.semicolon.springBank.dto.customerRequest.RegisterCustomerRequest;
import com.semicolon.springBank.dto.customerRequest.TransferRequest;
import com.semicolon.springBank.dto.customerResponse.DepositResponse;
import com.semicolon.springBank.dto.customerResponse.LoginCustomerResponse;
import com.semicolon.springBank.dto.customerResponse.RegisterCustomerResponse;
import com.semicolon.springBank.dto.customerResponse.TransferResponse;
import com.semicolon.springBank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/login")
    public LoginCustomerResponse loginRequest(@RequestBody RegisterCustomerRequest request){
        return customerService.loginCustomerRequest(new LoginCustomerRequest());
    }

    @PostMapping("/registration")
    public RegisterCustomerResponse register(@RequestBody RegisterCustomerRequest request){
        return customerService.createAccount(request);
    }
    @PostMapping("/deposit")
    public DepositResponse deposit(@RequestBody DepositRequest depositRequest){
        return customerService.deposit(depositRequest);
    }
    @PostMapping("/transfer")
    public TransferResponse transfer(@RequestBody TransferRequest transferRequest){
        return customerService.transfer(transferRequest);
    }

}
