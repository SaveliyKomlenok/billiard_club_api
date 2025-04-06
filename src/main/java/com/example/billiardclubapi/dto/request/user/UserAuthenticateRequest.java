package com.example.billiardclubapi.dto.request.user;

public record UserAuthenticateRequest(
        String username,
        String password
) {
}
