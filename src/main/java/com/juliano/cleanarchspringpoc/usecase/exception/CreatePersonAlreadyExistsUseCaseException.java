package com.juliano.cleanarchspringpoc.usecase.exception;

public class CreatePersonAlreadyExistsUseCaseException extends UseCaseException {

    private static final long serialVersionUID = 1L;

    public CreatePersonAlreadyExistsUseCaseException(String message) {
        super(message);
    }

    public CreatePersonAlreadyExistsUseCaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
