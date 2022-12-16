package com.semicolon.springBank.exceptions;

public class WrongPasswordException extends RuntimeException{

    public WrongPasswordException(String message){
        super(message);
    }
}
