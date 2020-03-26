package com.juliano.cleanarchspringpoc.gateway.database.mapper;

import com.juliano.cleanarchspringpoc.domain.Person;
import com.juliano.cleanarchspringpoc.gateway.database.model.PersonDatabase;
import org.mapstruct.Mapper;

@Mapper
public interface PersonDatabaseMapper {

    PersonDatabase personToPersonDatabase(final Person source);

    Person personDatabaseToPerson(final PersonDatabase source);
}
