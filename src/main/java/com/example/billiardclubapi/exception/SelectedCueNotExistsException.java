package com.example.billiardclubapi.exception;

public class SelectedCueNotExistsException extends RuntimeException {
    public SelectedCueNotExistsException(String message) {
        super(message);
    }
}
