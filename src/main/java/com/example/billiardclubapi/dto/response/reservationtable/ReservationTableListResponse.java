package com.example.billiardclubapi.dto.response.reservationtable;

import lombok.Builder;

import java.util.List;

@Builder
public record ReservationTableListResponse(
        List<ReservationTableResponse> items
) {
}
