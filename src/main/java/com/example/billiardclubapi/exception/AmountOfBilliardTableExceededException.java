package com.example.billiardclubapi.exception;

public class AmountOfBilliardTableExceededException extends RuntimeException {
    public AmountOfBilliardTableExceededException(String message) {
        super(message);
    }
}
