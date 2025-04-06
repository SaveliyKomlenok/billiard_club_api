package com.example.billiardclubapi.mapper;

import com.example.billiardclubapi.dto.request.selectedtable.SelectedTableRequest;
import com.example.billiardclubapi.dto.response.selectedtable.SelectedTableListResponse;
import com.example.billiardclubapi.dto.response.selectedtable.SelectedTableResponse;
import com.example.billiardclubapi.entity.SelectedTable;
import com.example.billiardclubapi.service.BilliardTableService;
import com.example.billiardclubapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SelectedTableMapper {
    private final BilliardTableService billiardTableService;
    private final BilliardTableMapper billiardTableMapper;
    private final UserService userService;

    public SelectedTable toEntity(SelectedTableRequest request, Long userId) {
        return SelectedTable.builder()
                .amount(request.amount())
                .user(userService.getById(userId))
                .billiardTable(billiardTableService.getById(request.billiardTable()))
                .build();
    }

    public SelectedTable toEntity(Long id, SelectedTableRequest request, Long userId) {
        return SelectedTable.builder()
                .id(id)
                .amount(request.amount())
                .user(userService.getById(userId))
                .billiardTable(billiardTableService.getById(request.billiardTable()))
                .build();
    }

    public SelectedTableResponse toResponse(SelectedTable selectedTable) {
        return SelectedTableResponse.builder()
                .id(selectedTable.getId())
                .amount(selectedTable.getAmount())
                .billiardTable(billiardTableMapper.toResponse(selectedTable.getBilliardTable()))
                .build();
    }

    public SelectedTableListResponse toListResponse(List<SelectedTable> selectedTableList) {
        List<SelectedTableResponse> selectedTableResponseList = selectedTableList.stream()
                .map(this::toResponse)
                .toList();
        return SelectedTableListResponse.builder()
                .items(selectedTableResponseList)
                .build();
    }
}
