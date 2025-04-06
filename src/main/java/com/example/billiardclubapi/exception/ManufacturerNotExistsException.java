package com.example.billiardclubapi.exception;

public class ManufacturerNotExistsException extends RuntimeException {
    public ManufacturerNotExistsException(String message) {
        super(message);
    }
}
