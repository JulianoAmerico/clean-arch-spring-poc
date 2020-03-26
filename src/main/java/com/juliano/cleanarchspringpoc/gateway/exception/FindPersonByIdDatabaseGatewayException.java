package com.juliano.cleanarchspringpoc.gateway.exception;

public class FindPersonByIdDatabaseGatewayException extends Exception {

    private static final long serialVersionUID = -1L;

    public FindPersonByIdDatabaseGatewayException(String message) {
        super(message);
    }

    public FindPersonByIdDatabaseGatewayException(String message, Throwable cause) {
        super(message, cause);
    }
}
