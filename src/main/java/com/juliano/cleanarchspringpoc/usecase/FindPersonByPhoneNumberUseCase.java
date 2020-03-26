package com.juliano.cleanarchspringpoc.usecase;

import com.juliano.cleanarchspringpoc.domain.Person;
import com.juliano.cleanarchspringpoc.gateway.FindPersonByPhoneNumberGateway;
import com.juliano.cleanarchspringpoc.gateway.exception.FindPersonByIdDatabaseGatewayException;
import com.juliano.cleanarchspringpoc.usecase.exception.FindPersonByPhoneNumberUseCaseException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindPersonByPhoneNumberUseCase {

    private final FindPersonByPhoneNumberGateway findPersonByPhoneNumberGateway;

    public FindPersonByPhoneNumberUseCase(final FindPersonByPhoneNumberGateway findPersonByPhoneNumberGateway) {
        this.findPersonByPhoneNumberGateway = findPersonByPhoneNumberGateway;
    }

    public Optional<Person> execute(final String phoneNumber) throws FindPersonByPhoneNumberUseCaseException {

        try {

            return findPersonByPhoneNumberGateway.execute(phoneNumber);

        } catch (FindPersonByIdDatabaseGatewayException e) {

            e.printStackTrace();

            throw new FindPersonByPhoneNumberUseCaseException("Error when try to find person by phone number", e);

        }
    }
}
