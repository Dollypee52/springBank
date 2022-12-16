package com.semicolon.springBank.exceptions;

public class AccountNotExistException extends RuntimeException{

    public AccountNotExistException(String message){
        super(message);
    }

}
