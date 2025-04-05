package com.example.billiardclubapi.dto.response.cue;

import lombok.Builder;

import java.util.List;

@Builder
public record CueListResponse(
        List<CueResponse> items
) {
}
