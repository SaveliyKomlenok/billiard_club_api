package com.example.billiardclubapi.exception;

public class CueTypeNotExistsException extends RuntimeException {
    public CueTypeNotExistsException(String message) {
        super(message);
    }
}
