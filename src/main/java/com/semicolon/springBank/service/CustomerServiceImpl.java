package com.semicolon.springBank.service;

import com.semicolon.springBank.dto.customerRequest.LoginCustomerRequest;
import com.semicolon.springBank.dto.customerResponse.LoginCustomerResponse;
import com.semicolon.springBank.exceptions.EmailNotFoundException;
import com.semicolon.springBank.models.Customer;
import com.semicolon.springBank.repository.CustomerRepository;
import com.semicolon.springBank.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public LoginCustomerResponse loginCustomerRequest(LoginCustomerRequest loginCustomerRequest) {
        Optional<Customer> savedCustomer = customerRepository.findByEmail(loginCustomerRequest.getEmail());
        if (savedCustomer.isPresent()) {
            if (savedCustomer.get().getPassword().equals(loginCustomerRequest.getPassword())) {
                LoginCustomerResponse loginCustomerResponse = new LoginCustomerResponse();
                loginCustomerResponse.setMessage("Welcome back" + savedCustomer.get().getFirstName());
                Mapper.map(savedCustomer, loginCustomerResponse);
                return new LoginCustomerResponse();
            }

        }
        throw new EmailNotFoundException("Email not found");

    }
}

