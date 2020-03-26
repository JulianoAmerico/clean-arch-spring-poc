package com.juliano.cleanarchspringpoc.controller.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ErrorResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> errors;

    public void addError(final String error) {

        if (Objects.isNull(errors)) {

            errors = new ArrayList<>();

        }

        errors.add(error);

    }
}
