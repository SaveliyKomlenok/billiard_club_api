package com.example.billiardclubapi.exceptionhandler;

public record Violation(
        String fieldName,
        String message) {
}
