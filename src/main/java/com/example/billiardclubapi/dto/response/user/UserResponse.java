package com.example.billiardclubapi.dto.response.user;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserResponse(
        Long id,
        String username,
        String firstname,
        String lastname,
        LocalDateTime createdAt
) {
}
