package com.semicolon.springBank.service;

import com.semicolon.springBank.dto.customerRequest.LoginCustomerRequest;
import com.semicolon.springBank.dto.customerResponse.LoginCustomerResponse;

public interface CustomerService {

    LoginCustomerResponse loginCustomerRequest(LoginCustomerRequest loginCustomerRequest);
}
