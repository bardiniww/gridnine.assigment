package com.gridnine.testing.service.exception;

public class IllegalDatesCountException extends Exception {
    public IllegalDatesCountException(String message) {
        super(message);
    }

    public IllegalDatesCountException(String message, Throwable cause) { super(message, cause); }
}
