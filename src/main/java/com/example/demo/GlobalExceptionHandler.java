package com.example.demo;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = NoSuchCustomerExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ResponsePojo handleException(NoSuchCustomerExistsException ex) {
        return new com.example.demo.ResponsePojo( HttpStatus.NOT_FOUND.value(), ex.getMessage()) {
        };
    }
}
