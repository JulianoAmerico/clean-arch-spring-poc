package com.juliano.cleanarchspringpoc.controller.handler;

import com.juliano.cleanarchspringpoc.usecase.exception.UseCaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler({UseCaseException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse useCaseException(final UseCaseException e) {

        return ErrorResponse.builder()
                .message(e.getMessage())
                .build();

    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMissingServletRequestParameterException(final MethodArgumentNotValidException e) {

        final ErrorResponse response = ErrorResponse.builder()
                .message("Invalids fields.")
                .build();

        e.getBindingResult().getFieldErrors().forEach(error -> response.addError(error.getDefaultMessage()));

        return response;

    }

}
