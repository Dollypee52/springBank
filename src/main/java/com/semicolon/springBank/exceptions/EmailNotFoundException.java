package com.semicolon.springBank.exceptions;

public class EmailNotFoundException extends RuntimeException{

    public EmailNotFoundException(String message){

        super(message);
    }
}
