package com.hamed.ecommerce.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerNotFoundException extends RuntimeException {


    private final String msg;
    // Constructor that accepts a message
    public CustomerNotFoundException(String msg) {
        super(msg); // Pass the message to the RuntimeException constructor
        this.msg = msg; // Set the 'msg' field explicitly
    }
}
