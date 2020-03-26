package com.juliano.cleanarchspringpoc.gateway.database.repository;

import com.juliano.cleanarchspringpoc.gateway.database.model.PersonDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonDatabase, Long> {

}
