package com.pashin.exceptions;

public class DuplicateModelNameException extends Exception {
    public DuplicateModelNameException() {
    }

    public DuplicateModelNameException(String message) {
        super(message);
    }
}
