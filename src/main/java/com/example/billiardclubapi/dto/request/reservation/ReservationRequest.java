package com.example.billiardclubapi.dto.request.reservation;

import java.time.LocalDateTime;

public record ReservationRequest(
      String address,
      LocalDateTime reservationDate,
      LocalDateTime reservationTime,
      Integer durationHours
) {
}
