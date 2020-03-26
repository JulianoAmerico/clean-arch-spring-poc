package com.juliano.cleanarchspringpoc.controller.translator;

import com.juliano.cleanarchspringpoc.client.model.request.CreatePersonRequest;
import com.juliano.cleanarchspringpoc.controller.mapper.PersonMapper;
import com.juliano.cleanarchspringpoc.domain.Person;
import lombok.experimental.UtilityClass;
import org.mapstruct.factory.Mappers;

@UtilityClass
public class CreatePersonRequestToPersonTranslator {

    private static final PersonMapper MAPPER = Mappers.getMapper(PersonMapper.class);

    public static Person execute(final CreatePersonRequest request) {
        return MAPPER.createPersonRequestToPerson(request);
    }
}
