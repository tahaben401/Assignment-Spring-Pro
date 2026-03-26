package com.example.microservicespro.handler;


import com.example.microservicespro.exception.PersonneNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalEcxeptionHandler {
    Logger logger = LoggerFactory.getLogger(GlobalEcxeptionHandler.class);
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> notFound(PersonneNotFoundException ex) {
        logger.warn("Personne Not found exception triggered");
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> validation(ConstraintViolationException ex) {
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(),ex.getConstraintViolations().stream().map(v -> v.getPropertyPath() + " : " + v.getMessage()).collect(Collectors.joining(" ,"))), HttpStatus.BAD_REQUEST);
    }
}
