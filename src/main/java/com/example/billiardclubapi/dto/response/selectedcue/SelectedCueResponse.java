package com.example.billiardclubapi.dto.response.selectedcue;

import com.example.billiardclubapi.dto.response.cue.CueResponse;
import lombok.Builder;

@Builder
public record SelectedCueResponse(
        Long id,
        Integer amount,
        CueResponse cue
) {
}
