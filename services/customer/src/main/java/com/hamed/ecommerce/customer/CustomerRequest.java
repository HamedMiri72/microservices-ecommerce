package com.hamed.ecommerce.customer;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;



public record CustomerRequest(

        String id,

        @NotNull(message = "Customer first name is required")
        String firstname,

        @NotNull(message = "Customer last name is required")
        String lastname,

        @NotNull(message = "Customer email is Required")
        @Email(message = "Customer email is a valid email address")
        String email,
        Address address

) {
}
