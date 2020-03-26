package com.juliano.cleanarchspringpoc.usecase.exception;

public class CreatePersonUseCaseException extends Exception {

    private static final long serialVersionUID = 1L;

    public CreatePersonUseCaseException(String message) {
        super(message);
    }

    public CreatePersonUseCaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
