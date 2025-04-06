package com.example.billiardclubapi.dto.response.reservation;

import com.example.billiardclubapi.dto.response.user.UserResponse;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ReservationResponse(
        Long id,
        LocalDateTime createdAt,
        String address,
        String startReservationDate,
        String endReservationDate,
        Integer durationHours,
        UserResponse user
) {
}
