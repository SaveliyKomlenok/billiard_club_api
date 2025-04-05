package com.example.billiardclubapi.dto.response.cuetype;

import lombok.Builder;

import java.util.List;

@Builder
public record CueTypeListResponse(
        List<CueTypeResponse> items
) {
}
