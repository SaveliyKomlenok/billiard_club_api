package com.example.billiardclubapi.mapper;

import com.example.billiardclubapi.dto.response.selected.SelectedResponse;
import com.example.billiardclubapi.entity.SelectedCue;
import com.example.billiardclubapi.entity.SelectedTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SelectedMapper {
    private final SelectedCueMapper selectedCueMapper;
    private final SelectedTableMapper selectedTableMapper;

    public SelectedResponse toResponse(List<SelectedCue> selectedCueList, List<SelectedTable> selectedTableList) {
        return SelectedResponse.builder()
                .selectedCues(selectedCueList.stream()
                        .map(selectedCueMapper::toResponse)
                        .toList())
                .selectedTables(selectedTableList.stream()
                        .map(selectedTableMapper::toResponse)
                        .toList())
                .build();
    }
}
