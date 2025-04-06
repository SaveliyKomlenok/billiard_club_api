package com.example.billiardclubapi.dto.request.user;

public record UserEditRequest(
        String firstname,
        String lastname,
        String username
) {
}
