package com.example.billiardclubapi.enumiration;

public class BilliardTableTypeNotExistsException extends RuntimeException {
    public BilliardTableTypeNotExistsException(String message) {
        super(message);
    }
}
