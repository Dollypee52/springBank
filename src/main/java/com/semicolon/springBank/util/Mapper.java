package com.semicolon.springBank.util;

import com.semicolon.springBank.dto.customerRequest.RegisterCustomerRequest;
import com.semicolon.springBank.dto.customerResponse.LoginCustomerResponse;
import com.semicolon.springBank.dto.customerResponse.RegisterCustomerResponse;
import com.semicolon.springBank.models.Customer;

import java.util.Optional;

public class Mapper {

    public static void map(RegisterCustomerRequest request, Customer customer) {
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setAddress(request.getAddress());
        customer.setPhoneNumber(request.getPhoneNumber());
        customer.setEmail(request.getEmail());
        customer.setOccupation(request.getOccupation());
        customer.setPassword(request.getPassword());
    }
    public static void map(Customer savedCustomer, RegisterCustomerResponse customerResponse) {
        customerResponse.setMessage("Welcome on board "+ savedCustomer.getFirstName().toUpperCase() + ". Your account creation was successful.");
        customerResponse.setAccountNumber("Your account number is " + savedCustomer.getAccountNumber());

    }


           public static void map(Optional<Customer> savedCustomer, LoginCustomerResponse loginCustomerResponse) {
               loginCustomerResponse.setFirstName(savedCustomer.get().getFirstName());
              loginCustomerResponse.setLastName(savedCustomer.get().getLastName());
                loginCustomerResponse.setAccountNumber(savedCustomer.get().getAccountNumber());
              loginCustomerResponse.setBalance(savedCustomer.get().getBalance());
           }

}
