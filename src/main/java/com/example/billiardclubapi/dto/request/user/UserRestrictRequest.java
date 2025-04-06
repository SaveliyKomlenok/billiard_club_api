package com.example.billiardclubapi.dto.request.user;

public record UserRestrictRequest(
        Long id,
        boolean status
) {
}
