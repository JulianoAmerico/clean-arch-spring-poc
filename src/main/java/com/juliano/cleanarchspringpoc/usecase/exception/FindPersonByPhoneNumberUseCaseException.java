package com.juliano.cleanarchspringpoc.usecase.exception;

public class FindPersonByPhoneNumberUseCaseException extends UseCaseException {

    private static final long serialVersionUID = -1L;

    public FindPersonByPhoneNumberUseCaseException(String message) {
        super(message);
    }

    public FindPersonByPhoneNumberUseCaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
