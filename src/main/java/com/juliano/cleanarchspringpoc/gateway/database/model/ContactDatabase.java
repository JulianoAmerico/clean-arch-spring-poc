package com.juliano.cleanarchspringpoc.gateway.database.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDatabase {

    private Set<PersonDatabase> peopleDatabase;
}
