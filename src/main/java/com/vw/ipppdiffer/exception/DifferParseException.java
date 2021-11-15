package com.vw.ipppdiffer.exception;


public class DifferParseException extends Exception {

    private String message;

    public DifferParseException(String message) {
        super(message);
        this.message = message;
    }
}
