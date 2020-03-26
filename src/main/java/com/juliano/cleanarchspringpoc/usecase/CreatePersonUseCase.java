package com.juliano.cleanarchspringpoc.usecase;

import com.juliano.cleanarchspringpoc.domain.Person;
import com.juliano.cleanarchspringpoc.gateway.CreatePersonGateway;
import com.juliano.cleanarchspringpoc.gateway.exception.CreatePersonDatabaseGatewayException;
import com.juliano.cleanarchspringpoc.usecase.exception.CreatePersonAlreadyExistsUseCaseException;
import com.juliano.cleanarchspringpoc.usecase.exception.CreatePersonUseCaseException;
import com.juliano.cleanarchspringpoc.usecase.exception.FindPersonByPhoneNumberUseCaseException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreatePersonUseCase {

    private final CreatePersonGateway createPersonGateway;

    private final FindPersonByPhoneNumberUseCase findPersonByPhoneNumberUseCase;

    public CreatePersonUseCase(final CreatePersonGateway createPersonGateway,
                               final FindPersonByPhoneNumberUseCase findPersonByPhoneNumberUseCase) {
        this.createPersonGateway = createPersonGateway;
        this.findPersonByPhoneNumberUseCase = findPersonByPhoneNumberUseCase;
    }

    public Person execute(final Person person) throws CreatePersonUseCaseException, CreatePersonAlreadyExistsUseCaseException {

        try {

            final Optional<Person> personOptional = findPersonByPhoneNumberUseCase.execute(person.getPhoneNumber());

            if (personOptional.isPresent()) {
                throw new CreatePersonAlreadyExistsUseCaseException("There is a register with phone number: " + person.getPhoneNumber());
            }

            return createPersonGateway.execute(person);

        } catch (CreatePersonDatabaseGatewayException | FindPersonByPhoneNumberUseCaseException e) {

            e.printStackTrace();

            throw new CreatePersonUseCaseException("Error when try to create person", e);

        }
    }
}
