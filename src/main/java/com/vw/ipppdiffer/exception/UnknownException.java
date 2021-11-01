package com.vw.ipppdiffer.exception;


public class UnknownException extends RuntimeException{

    private String message;

    public UnknownException(String message) {
        super(message);
        this.message = message;
    }
}
