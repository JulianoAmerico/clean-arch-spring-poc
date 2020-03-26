package com.juliano.cleanarchspringpoc.gateway.database.repository;

import com.juliano.cleanarchspringpoc.gateway.database.model.PersonDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonDatabase, Long> {

    Optional<PersonDatabase> findByPhoneNumber(final String phoneNumber);
}
