package com.example.billiardclubapi.dto.response.reservationtable;

import com.example.billiardclubapi.dto.response.billiardtable.BilliardTableResponse;
import com.example.billiardclubapi.dto.response.reservation.ReservationResponse;
import lombok.Builder;

@Builder
public record ReservationTableResponse(
        Long id,
        Integer amount,
        BilliardTableResponse billiardTable
) {
}
