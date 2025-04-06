package com.example.billiardclubapi.dto.response.reservationcue;

import lombok.Builder;

import java.util.List;

@Builder
public record ReservationCueListResponse(
        List<ReservationCueResponse> items
) {
}
