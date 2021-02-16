package com.pashin.exceptions;

public class ModelPriceOutOfBoundsException extends IllegalArgumentException {
    public ModelPriceOutOfBoundsException() {
    }

    public ModelPriceOutOfBoundsException(String s) {
        super(s);
    }
}
