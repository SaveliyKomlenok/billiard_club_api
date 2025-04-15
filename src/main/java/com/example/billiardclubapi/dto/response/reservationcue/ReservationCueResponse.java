package com.example.billiardclubapi.dto.response.reservationcue;

import com.example.billiardclubapi.dto.response.cue.CueResponse;
import com.example.billiardclubapi.dto.response.reservation.ReservationResponse;
import lombok.Builder;

@Builder
public record ReservationCueResponse(
        Long id,
        Integer amount,
        CueResponse cue
) {
}
