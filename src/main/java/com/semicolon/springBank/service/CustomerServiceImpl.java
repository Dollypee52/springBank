package com.semicolon.springBank.service;

import com.semicolon.springBank.dto.customerRequest.DepositRequest;
import com.semicolon.springBank.dto.customerRequest.LoginCustomerRequest;
import com.semicolon.springBank.dto.customerRequest.RegisterCustomerRequest;
import com.semicolon.springBank.dto.customerRequest.TransferRequest;
import com.semicolon.springBank.dto.customerResponse.DepositResponse;
import com.semicolon.springBank.dto.customerResponse.LoginCustomerResponse;
import com.semicolon.springBank.dto.customerResponse.RegisterCustomerResponse;
import com.semicolon.springBank.dto.customerResponse.TransferResponse;
import com.semicolon.springBank.exceptions.*;
import com.semicolon.springBank.models.Customer;
import com.semicolon.springBank.repository.CustomerRepository;
import com.semicolon.springBank.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    private TransferRequest transferRequest;


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

    @Override
    public RegisterCustomerResponse createAccount(RegisterCustomerRequest request) {
        if(customerRepository.existsByEmail(request.getEmail())) throw new CustomerAlreadyExistException("Email already exist");
        Customer customer = new Customer();
        Mapper.map(request,customer);
        String accountNumber = String.valueOf(UUID.randomUUID().getMostSignificantBits());
        accountNumber = accountNumber.substring(1, 10);
        customer.setAccountNumber(accountNumber);

        Customer savedCustomer = customerRepository.save(customer);
        RegisterCustomerResponse customerResponse = new RegisterCustomerResponse();
        Mapper.map(savedCustomer,customerResponse);

        return customerResponse;
    }

    @Override
    public DepositResponse deposit(DepositRequest depositRequest) {
        Optional<Customer> savedCustomer = customerRepository.findByAccountNumber(depositRequest.getAccountNumber());
        if(savedCustomer.isPresent()){
            if(depositRequest.getAmount()>0){
                savedCustomer.get().setBalance(savedCustomer.get().getBalance() + depositRequest.getAmount());
                DepositResponse depositResponse =  new DepositResponse();
                depositResponse.setMessage("The deposit of " + depositRequest.getAmount() + " to " +
                       savedCustomer.get().getFirstName() + " " + savedCustomer.get().getLastName() + " was successful");
                depositResponse.setBalance(savedCustomer.get().getBalance());

                customerRepository.save(savedCustomer.get());
                return depositResponse;
            }
            else{
                throw new IllegalArgumentException("Invalid amount");
            }
        }
        throw new IllegalArgumentException("Invalid Account");

    }

    @Override
    public TransferResponse transfer(TransferRequest request) {
        Optional<Customer> sender = customerRepository.findByAccountNumber(transferRequest.getSenderAccountNumber());
        if(sender.isPresent()){
            if(sender.get().getPassword().equals(transferRequest.getPassword())){
                Optional<Customer> receiver = customerRepository.findByAccountNumber(transferRequest.getReceiverAccountNumber());
                if(receiver.isPresent()){
                    if(transferRequest.getAmount() > 0 && sender.get().getBalance() >= transferRequest.getAmount()){
                        sender.get().setBalance(sender.get().getBalance() - transferRequest.getAmount());
                        receiver.get().setBalance(receiver.get().getBalance() + transferRequest.getAmount());
                        TransferResponse transferResponse = new TransferResponse();
                        transferResponse.setMessage("You have successfully transferred" + transferRequest.getAmount()
                        + " to " + receiver.get().getFirstName() + "." + " Your remaining balance is "
                        + sender.get().getBalance());

                        customerRepository.save(sender.get());
                        customerRepository.save(receiver.get());
                        return transferResponse;
                    }
                    else{
                        throw new InvalidAmountException("Invalid amount");
                    }
                }else{
                    throw new AccountNotExistException("Receiver's account not exist");
                }
            }else{
                throw new WrongPasswordException("Incorrect Password");
            }
        }else{
            throw new AccountNotExistException("Account not found");
        }
    }
}

