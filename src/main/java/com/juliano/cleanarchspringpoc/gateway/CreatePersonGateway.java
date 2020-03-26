package com.juliano.cleanarchspringpoc.gateway;

import com.juliano.cleanarchspringpoc.domain.Person;
import com.juliano.cleanarchspringpoc.gateway.exception.CreatePersonDatabaseGatewayException;

public interface CreatePersonGateway {
    Person execute(final Person person) throws CreatePersonDatabaseGatewayException;
}
