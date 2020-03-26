package com.juliano.cleanarchspringpoc.gateway.database;

import com.juliano.cleanarchspringpoc.domain.Person;
import com.juliano.cleanarchspringpoc.gateway.CreatePersonGateway;
import com.juliano.cleanarchspringpoc.gateway.database.model.PersonDatabase;
import com.juliano.cleanarchspringpoc.gateway.database.repository.PersonRepository;
import com.juliano.cleanarchspringpoc.gateway.database.translator.PersonDatabaseToPersonTranslator;
import com.juliano.cleanarchspringpoc.gateway.database.translator.PersonToPersonDatabaseTranslator;
import com.juliano.cleanarchspringpoc.gateway.exception.CreatePersonDatabaseGatewayException;
import org.springframework.stereotype.Component;

@Component
public class CreatePersonDatabaseGatewayImpl implements CreatePersonGateway {

    private final PersonRepository repository;

    public CreatePersonDatabaseGatewayImpl(final PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public Person execute(final Person person) throws CreatePersonDatabaseGatewayException {

        try {

            final PersonDatabase personDatabase = PersonToPersonDatabaseTranslator.execute(person);

            final PersonDatabase personDatabaseResponse = repository.save(personDatabase);

            return PersonDatabaseToPersonTranslator.execute(personDatabaseResponse);

        } catch (Exception e) {

            e.printStackTrace();

            throw new CreatePersonDatabaseGatewayException("Error when try to create person on database", e);

        }
    }
}
