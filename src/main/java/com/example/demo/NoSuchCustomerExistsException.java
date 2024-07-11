package com.example.demo;

public class NoSuchCustomerExistsException extends RuntimeException {
    private String message;
    private int statusCode;

    public NoSuchCustomerExistsException() {}

    public NoSuchCustomerExistsException(int statusCode,String msg) {
        super(msg);
        this.message = msg;
    }
}