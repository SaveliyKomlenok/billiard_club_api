package com.example.billiardclubapi.dto.response.reservation;

import com.example.billiardclubapi.dto.response.reservationcue.ReservationCueResponse;
import com.example.billiardclubapi.dto.response.reservationtable.ReservationTableResponse;
import com.example.billiardclubapi.dto.response.user.UserResponse;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record ReservationResponse(
        Long id,
        String address,
        String startReservationDate,
        String endReservationDate,
        String status,
        UserResponse user,
        String createdAt,
        BigDecimal totalPrice,
        List<ReservationCueResponse> reservedCues,
        List<ReservationTableResponse> reservedBilliardTables
) {
}
