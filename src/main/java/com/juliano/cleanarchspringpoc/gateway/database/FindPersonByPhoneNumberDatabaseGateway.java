package com.juliano.cleanarchspringpoc.gateway.database;

import com.juliano.cleanarchspringpoc.domain.Person;
import com.juliano.cleanarchspringpoc.gateway.FindPersonByPhoneNumberGateway;
import com.juliano.cleanarchspringpoc.gateway.database.model.PersonDatabase;
import com.juliano.cleanarchspringpoc.gateway.database.repository.PersonRepository;
import com.juliano.cleanarchspringpoc.gateway.database.translator.PersonDatabaseToPersonTranslator;
import com.juliano.cleanarchspringpoc.gateway.exception.FindPersonByIdDatabaseGatewayException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindPersonByPhoneNumberDatabaseGateway implements FindPersonByPhoneNumberGateway {

    private final PersonRepository repository;

    public FindPersonByPhoneNumberDatabaseGateway(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Person> execute(final String phoneNumber) throws FindPersonByIdDatabaseGatewayException {

        try {

            final Optional<PersonDatabase> personDatabaseOptional = repository.findByPhoneNumber(phoneNumber);

            return personDatabaseOptional.map(PersonDatabaseToPersonTranslator::execute);

        } catch (Exception e) {

            e.printStackTrace();

            throw new FindPersonByIdDatabaseGatewayException("Error when try to find person by phoneNumber on database", e);

        }
    }
}
