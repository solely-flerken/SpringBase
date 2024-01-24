package com.flerken.springbase.internal.exceptions;

public class InvalidUnitException extends RuntimeException {
    public InvalidUnitException() {
        super();
    }

    public InvalidUnitException(String message) {
        super(message);
    }
}
