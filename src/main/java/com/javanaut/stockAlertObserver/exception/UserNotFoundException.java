package com.javanaut.stockAlertObserver.exception;

public class UserNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private final int errorCode;

    public UserNotFoundException(String message){
        super(message);
        this.errorCode = 404;
    }
}
