package com.example.billiardclubapi.exception;

public class AmountOfCueExceededException extends RuntimeException {
    public AmountOfCueExceededException(String message) {
        super(message);
    }
}
