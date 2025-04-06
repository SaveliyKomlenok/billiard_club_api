package com.example.billiardclubapi.dto.response.selected;

import com.example.billiardclubapi.dto.response.selectedcue.SelectedCueResponse;
import com.example.billiardclubapi.dto.response.selectedtable.SelectedTableResponse;
import lombok.Builder;

import java.util.List;

@Builder
public record SelectedResponse(
        List<SelectedCueResponse> selectedCues,
        List<SelectedTableResponse> selectedTables
) {
}
