package com.juliano.cleanarchspringpoc.gateway.database.translator;

import com.juliano.cleanarchspringpoc.domain.Person;
import com.juliano.cleanarchspringpoc.gateway.database.mapper.PersonDatabaseMapper;
import com.juliano.cleanarchspringpoc.gateway.database.model.PersonDatabase;
import lombok.experimental.UtilityClass;
import org.mapstruct.factory.Mappers;

@UtilityClass
public class PersonDatabaseToPersonTranslator {

    private static final PersonDatabaseMapper MAPPER = Mappers.getMapper(PersonDatabaseMapper.class);

    public static Person execute(final PersonDatabase personDatabase) {
        return MAPPER.personDatabaseToPerson(personDatabase);
    }
}
