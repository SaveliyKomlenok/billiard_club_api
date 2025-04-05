package com.example.billiardclubapi.dto.response.cuetype;

import lombok.Builder;

@Builder
public record CueTypeResponse(
        Long id,
        String name
) {
}
