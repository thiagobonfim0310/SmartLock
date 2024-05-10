package com.smartlock.business.exceptions;

public class EmailNotFoundException extends Exception {
    public EmailNotFoundException() {
        super("email não encontrado");
    }

    public EmailNotFoundException(String message) {
        super(message);
    }
}
