package com.example.billiardclubapi.exceptionhandler;

import java.util.List;

public record ValidationErrorResponse(List<Violation> violations) {
}
