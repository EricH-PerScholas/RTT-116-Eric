package com.example.module309.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ToString
public class CreateCustomerFormBean {

    // this is called a POJO - Plain Old Java Object
    // this object is called a FormBean
    // this is analgous to a DTO (Data Transport Object)
    // this is NEVER EVER an entity
    // the variable names here do need to match exactly what is in the name attribute on the HTML input field

    // JSR 303 Annotations
    // https://www.geeksforgeeks.org/spring-bean-validation-jsr-303-annotations/

    @Pattern(regexp = "[A-Za-z0-9\\s]+", message = "Company name must contain only letters, numbers, and spaces.")
    @Length(min = 5, message = "Company name longer than 5 characters.")
    @Length(max = 10, message = "Company name must be less than 50 characters.")
    @NotEmpty(message = "Company name is required.")
    private String companyName;

    @Length(max = 50, message = "First name must be less than 50 characters.")
    @NotEmpty(message = "First Name is required.")
    private String firstName;

    @Length(max = 50, message = "Last name must be less than 50 characters.")
    @NotEmpty(message = "Last name is required.")
    private String lastName;

    @Length(max = 50, message = "Phone number must be less than 50 characters.")
    @NotEmpty(message = "Phone number is required.")
    private String phone;

    @Length(max = 50, message = "Address line 1 must be less than 50 characters.")
    @NotEmpty(message = "Address Line 1 is required.")
    private String addressLine1;

    @Length(max = 50, message = "City must be less than 50 characters.")
    @NotEmpty(message = "City name is required.")
    private String city;

    @Length(max = 50, message = "Country must be less than 50 characters.")
    @NotEmpty(message = "Country name is required.")
    private String country;


}
