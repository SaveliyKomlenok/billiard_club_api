package com.example.billiardclubapi.exception;

public class CueNotExistsException extends RuntimeException {
    public CueNotExistsException(String message) {
        super(message);
    }
}
