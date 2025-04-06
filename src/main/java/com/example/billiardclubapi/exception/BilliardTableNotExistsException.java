package com.example.billiardclubapi.exception;

public class BilliardTableNotExistsException extends RuntimeException {
    public BilliardTableNotExistsException(String message) {
        super(message);
    }
}
