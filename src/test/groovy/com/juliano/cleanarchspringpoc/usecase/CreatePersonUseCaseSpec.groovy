package com.juliano.cleanarchspringpoc.usecase

import com.juliano.cleanarchspringpoc.domain.Person
import com.juliano.cleanarchspringpoc.gateway.CreatePersonGateway
import com.juliano.cleanarchspringpoc.gateway.exception.CreatePersonDatabaseGatewayException
import com.juliano.cleanarchspringpoc.usecase.exception.CreatePersonAlreadyExistsUseCaseException
import com.juliano.cleanarchspringpoc.usecase.exception.CreatePersonUseCaseException
import spock.lang.Specification

class CreatePersonUseCaseSpec extends Specification {

    private final CreatePersonGateway createPersonGateway = Mock(CreatePersonGateway)
    private final FindPersonByPhoneNumberUseCase findPersonByPhoneNumberUseCase = Mock(FindPersonByPhoneNumberUseCase)
    private final CreatePersonUseCase createPersonUseCase =
            new CreatePersonUseCase(createPersonGateway, findPersonByPhoneNumberUseCase)

    def "It should create a person with success"() {
        given: "a valid person"
        final Person person = getPerson()

        when: "use case is called"
        final Person createdPerson = createPersonUseCase.execute(person)

        then: "should not find a person by phone number"
        1 * findPersonByPhoneNumberUseCase.execute(_ as String) >> {
            Optional.empty()
        }

        and: "should create person on gateway"
        1 * createPersonGateway.execute(_ as Person) >> {
            getPersonWithId()
        }

        and: "valid created person"
        person.getFirstName() == createdPerson.getFirstName()
        person.getLastName() == createdPerson.getLastName()
        person.getPhoneNumber() == createdPerson.getPhoneNumber()
        createdPerson.getId() == getPersonWithId().getId()

    }

    def "It should not create person if already exists phone number in data source" () {

        given: "a valid person"
        final Person person = getPerson()

        when: "use case is called"
        createPersonUseCase.execute(person)

        then: "should find a person by phone number"
        1 * findPersonByPhoneNumberUseCase.execute(_ as String) >> {
            Optional.of(getPersonWithId())
        }

        and: "should not create person on gateway"
        0 * createPersonGateway.execute(_ as Person)

        and: "throw exception"
        thrown(CreatePersonAlreadyExistsUseCaseException)

    }

    def "It should not create person when gateway throw an exception" () {

        given: "a valid person"
        final Person person = getPerson()

        when: "use case is called"
        createPersonUseCase.execute(person)

        then: "should not find a person by phone number"
        1 * findPersonByPhoneNumberUseCase.execute(_ as String) >> {
            Optional.empty()
        }

        and: "should be error on gateway"
        1 * createPersonGateway.execute(_ as Person) >> {
            throw new CreatePersonDatabaseGatewayException("Error when try to create person on gateway")
        }

        and: "throw exception"
        thrown(CreatePersonUseCaseException)
    }

    def "It should be error when person is invalid" () {

        given: "an invalid person"
        final Person person = getInvalidPerson()

        when: "use case is called"
        createPersonUseCase.execute(person)

        then: "should not call find person by phone number"
        0 * findPersonByPhoneNumberUseCase.execute(_ as String)

        and: "should not call gateway"
        0 * createPersonGateway.execute(_ as Person)

        and: "throw exception"
        thrown(CreatePersonUseCaseException)
    }

    static def getPerson() {
        Person.builder()
                .firstName("Juliano")
                .lastName("Américo")
                .phoneNumber("99707077070")
                .build()
    }

    static def getPersonWithId() {
        Person.builder()
                .id(1)
                .firstName("Juliano")
                .lastName("Américo")
                .phoneNumber("99707077070")
                .build()
    }

    static def getInvalidPerson() {
        Person.builder()
        .lastName("Américo")
        .build()
    }
}
