package com.craftdemo.service1.exceptions;

public class CustomRunTimeExceptions extends RuntimeException {
    public CustomRunTimeExceptions(String message) {
        super(message);
    }
}
