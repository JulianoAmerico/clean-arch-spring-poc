package com.juliano.cleanarchspringpoc.client;

import com.juliano.cleanarchspringpoc.client.model.request.CreatePersonRequest;
import com.juliano.cleanarchspringpoc.client.model.response.CreatePersonResponse;
import com.juliano.cleanarchspringpoc.usecase.exception.UseCaseException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("people")
public interface CreatePersonApi {

    @PostMapping
    CreatePersonResponse execute(@RequestBody @Valid final CreatePersonRequest request) throws UseCaseException;
}
