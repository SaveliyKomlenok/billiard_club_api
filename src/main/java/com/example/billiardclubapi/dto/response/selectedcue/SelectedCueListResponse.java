package com.example.billiardclubapi.dto.response.selectedcue;

import lombok.Builder;

import java.util.List;

@Builder
public record SelectedCueListResponse(
        List<SelectedCueResponse> items
) {
}
