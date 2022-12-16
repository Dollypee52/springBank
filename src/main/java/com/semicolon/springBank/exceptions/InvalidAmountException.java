package com.semicolon.springBank.exceptions;

public class InvalidAmountException extends RuntimeException{

    public InvalidAmountException(String message){
        super(message);
    }
}
