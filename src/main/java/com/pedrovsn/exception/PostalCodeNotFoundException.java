package com.pedrovsn.exception;

public class PostalCodeNotFoundException extends RuntimeException {

    public PostalCodeNotFoundException(Long id) {
        super("Demo " + id + " not found");
    }
}
