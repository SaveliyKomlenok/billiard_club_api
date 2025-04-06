package com.example.billiardclubapi.dto.response.selectedtable;

import lombok.Builder;

import java.util.List;

@Builder
public record SelectedTableListResponse(
        List<SelectedTableResponse> items
) {
}
