package com.javanaut.stockAlertObserver.exception;

public class ProductNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private final int errorCode;

    public ProductNotFoundException(String message) {
        super(message);
        this.errorCode = 404;
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = 404;
    }

    public ProductNotFoundException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ProductNotFoundException(String message, int errorCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
