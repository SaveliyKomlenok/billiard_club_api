package com.example.billiardclubapi.dto.response.billiardtabletype;

import lombok.Builder;

@Builder
public record BilliardTableTypeResponse(
        Long id,
        String name
) {
}
