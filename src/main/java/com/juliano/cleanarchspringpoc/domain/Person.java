package com.juliano.cleanarchspringpoc.domain;

import lombok.*;

@EqualsAndHashCode(of = "phoneNumber")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person {

    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;
}
