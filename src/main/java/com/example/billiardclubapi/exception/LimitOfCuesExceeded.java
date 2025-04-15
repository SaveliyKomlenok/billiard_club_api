package com.example.billiardclubapi.exception;

public class LimitOfCuesExceeded extends RuntimeException {
    public LimitOfCuesExceeded(String message) {
        super(message);
    }
}
