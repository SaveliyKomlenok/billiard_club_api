package com.example.billiardclubapi.dto.request.selectedtable;

public record SelectedTableRequest(
        Integer amount,
        Long billiardTable
) {
}
