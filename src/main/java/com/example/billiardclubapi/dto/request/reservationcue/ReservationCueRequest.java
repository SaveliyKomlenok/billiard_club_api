package com.example.billiardclubapi.dto.request.reservationcue;

public record ReservationCueRequest(
        Integer amount,
        Long cue,
        Long reservation
) {
}
