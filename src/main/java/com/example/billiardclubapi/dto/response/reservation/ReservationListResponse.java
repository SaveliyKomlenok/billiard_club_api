package com.example.billiardclubapi.dto.response.reservation;

import lombok.Builder;

import java.util.List;

@Builder
public record ReservationListResponse(
        List<ReservationResponse> items
) {
}
