package com.example.billiardclubapi.dto.request.reservationtable;

public record ReservationTableRequest(
        Integer amount,
        Long billiardTable,
        Long reservation
) {
}
