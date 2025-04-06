package com.example.billiardclubapi.dto.response.selectedtable;

import com.example.billiardclubapi.dto.response.billiardtable.BilliardTableResponse;
import com.example.billiardclubapi.dto.response.cue.CueResponse;
import lombok.Builder;

@Builder
public record SelectedTableResponse(
        Long id,
        Integer amount,
        BilliardTableResponse billiardTable
) {
}
