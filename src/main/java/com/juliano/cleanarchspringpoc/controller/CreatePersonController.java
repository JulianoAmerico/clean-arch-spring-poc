package com.juliano.cleanarchspringpoc.controller;

import com.juliano.cleanarchspringpoc.client.CreatePersonApi;
import com.juliano.cleanarchspringpoc.client.model.request.CreatePersonRequest;
import com.juliano.cleanarchspringpoc.client.model.response.CreatePersonResponse;
import com.juliano.cleanarchspringpoc.controller.translator.CreatePersonRequestToPersonTranslator;
import com.juliano.cleanarchspringpoc.controller.translator.PersonToCreatePersonResponseTranslator;
import com.juliano.cleanarchspringpoc.domain.Person;
import com.juliano.cleanarchspringpoc.usecase.CreatePersonUseCase;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CreatePersonController implements CreatePersonApi {

    private final CreatePersonUseCase createPersonUseCase;

    public CreatePersonController(CreatePersonUseCase createPersonUseCase) {
        this.createPersonUseCase = createPersonUseCase;
    }

    @Override
    public CreatePersonResponse execute(@Valid CreatePersonRequest request) throws Exception {

        final Person person = CreatePersonRequestToPersonTranslator.execute(request);

        final Person personResponse = createPersonUseCase.execute(person);

        return PersonToCreatePersonResponseTranslator.execute(personResponse);

    }
}
