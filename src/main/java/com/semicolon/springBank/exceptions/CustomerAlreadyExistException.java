package com.semicolon.springBank.exceptions;

public class CustomerAlreadyExistException extends RuntimeException{

    public CustomerAlreadyExistException(String message){
        super(message);
    }

}
