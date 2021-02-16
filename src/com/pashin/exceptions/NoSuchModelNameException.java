package com.pashin.exceptions;

public class NoSuchModelNameException extends Exception {
    public NoSuchModelNameException() {
    }

    public NoSuchModelNameException(String message) {
        super(message);
    }
}
