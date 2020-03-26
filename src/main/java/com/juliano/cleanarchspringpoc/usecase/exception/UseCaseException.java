package com.juliano.cleanarchspringpoc.usecase.exception;

public class UseCaseException extends Exception {

    private static final long serialVersionUID = 1L;

    public UseCaseException(String message) {
        super(message);
    }

    public UseCaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
