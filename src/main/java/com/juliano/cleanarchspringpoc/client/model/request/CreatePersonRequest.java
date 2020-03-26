package com.juliano.cleanarchspringpoc.client.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreatePersonRequest {

    private Long partnerId;

    @JsonProperty
    @NotEmpty(message = "The field first name must be informed.")
    private String firstName;

    @JsonProperty
    @NotEmpty(message = "The field last name must be informed.")
    private String lastName;

    @JsonProperty
    @NotEmpty(message = "The field phone number must be informed.")
    private String phoneNumber;

}
