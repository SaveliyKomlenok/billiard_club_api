package com.example.billiardclubapi.dto.request.user;

public record UserRegisterRequest(
        String username,
        String firstname,
        String lastname,
        String password
) {
}
