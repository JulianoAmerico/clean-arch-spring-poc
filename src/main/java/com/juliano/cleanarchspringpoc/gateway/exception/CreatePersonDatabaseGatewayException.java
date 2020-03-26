package com.juliano.cleanarchspringpoc.gateway.exception;

public class CreatePersonDatabaseGatewayException extends Exception {

    private static final long serialVersionUID = -1L;

    public CreatePersonDatabaseGatewayException(String message) {
        super(message);
    }

    public CreatePersonDatabaseGatewayException(String message, Throwable cause) {
        super(message, cause);
    }
}
