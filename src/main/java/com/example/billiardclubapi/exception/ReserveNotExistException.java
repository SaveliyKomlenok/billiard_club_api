package com.example.billiardclubapi.exception;

public class ReserveNotExistException extends RuntimeException {
    public ReserveNotExistException(String message) {
        super(message);
    }
}
