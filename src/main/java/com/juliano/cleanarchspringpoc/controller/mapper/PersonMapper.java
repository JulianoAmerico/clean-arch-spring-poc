package com.juliano.cleanarchspringpoc.controller.mapper;

import com.juliano.cleanarchspringpoc.client.model.request.CreatePersonRequest;
import com.juliano.cleanarchspringpoc.client.model.response.CreatePersonResponse;
import com.juliano.cleanarchspringpoc.domain.Person;
import org.mapstruct.Mapper;

@Mapper
public interface PersonMapper {

    Person createPersonRequestToPerson(CreatePersonRequest source);

    CreatePersonResponse personToCreatePersonResponse(Person source);

}
