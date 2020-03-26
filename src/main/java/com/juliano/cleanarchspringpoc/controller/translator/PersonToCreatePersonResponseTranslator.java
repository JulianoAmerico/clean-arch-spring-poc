package com.juliano.cleanarchspringpoc.controller.translator;

import com.juliano.cleanarchspringpoc.client.model.response.CreatePersonResponse;
import com.juliano.cleanarchspringpoc.controller.mapper.PersonMapper;
import com.juliano.cleanarchspringpoc.domain.Person;
import lombok.experimental.UtilityClass;
import org.mapstruct.factory.Mappers;

@UtilityClass
public class PersonToCreatePersonResponseTranslator {

    private static final PersonMapper MAPPER = Mappers.getMapper(PersonMapper.class);

    public static CreatePersonResponse execute(final Person domain) {
        return MAPPER.personToCreatePersonResponse(domain);
    }
}
