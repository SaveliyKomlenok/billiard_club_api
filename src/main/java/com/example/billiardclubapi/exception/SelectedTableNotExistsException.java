package com.example.billiardclubapi.exception;

public class SelectedTableNotExistsException extends RuntimeException {
    public SelectedTableNotExistsException(String message) {
        super(message);
    }
}
