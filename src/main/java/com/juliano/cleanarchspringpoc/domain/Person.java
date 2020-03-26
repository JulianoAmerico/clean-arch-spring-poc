package com.juliano.cleanarchspringpoc.domain;

import lombok.*;

import java.util.Objects;

@EqualsAndHashCode(of = "phoneNumber")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Person {

    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    public boolean isValidToCreate() {
        return Objects.nonNull(firstName) &&
                Objects.nonNull(lastName) &&
                Objects.nonNull(phoneNumber);
    }
}
