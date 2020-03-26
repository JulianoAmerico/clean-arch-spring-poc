package com.juliano.cleanarchspringpoc.usecase;

import com.juliano.cleanarchspringpoc.domain.Person;
import com.juliano.cleanarchspringpoc.gateway.CreatePersonGateway;
import com.juliano.cleanarchspringpoc.gateway.exception.CreatePersonDatabaseGatewayException;
import com.juliano.cleanarchspringpoc.usecase.exception.CreatePersonUseCaseException;
import org.springframework.stereotype.Service;

@Service
public class CreatePersonUseCase {

    private final CreatePersonGateway createPersonGateway;

    public CreatePersonUseCase(CreatePersonGateway createPersonGateway) {
        this.createPersonGateway = createPersonGateway;
    }

    public Person execute(final Person person) throws CreatePersonUseCaseException {

        try {

            return createPersonGateway.execute(person);

        } catch (CreatePersonDatabaseGatewayException e) {

            e.printStackTrace();

            throw new CreatePersonUseCaseException("Error when try to create person", e);

        }
    }
}
