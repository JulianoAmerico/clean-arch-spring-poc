package com.juliano.cleanarchspringpoc.gateway;

import com.juliano.cleanarchspringpoc.domain.Person;
import com.juliano.cleanarchspringpoc.gateway.exception.FindPersonByIdDatabaseGatewayException;

import java.util.Optional;

public interface FindPersonByPhoneNumberGateway {

    Optional<Person> execute(final String phoneNumber) throws FindPersonByIdDatabaseGatewayException;

}
