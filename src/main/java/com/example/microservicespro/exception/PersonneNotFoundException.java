package com.example.microservicespro.exception;

public class PersonneNotFoundException extends RuntimeException {
    public PersonneNotFoundException(long id) {
        super(
                "Personne " + id + " n'existe pas"
        );
    }
}
