package com.example.billiardclubapi.mapper;

import com.example.billiardclubapi.dto.request.reservationtable.ReservationTableRequest;
import com.example.billiardclubapi.dto.response.reservationtable.ReservationTableResponse;
import com.example.billiardclubapi.dto.response.reservationtable.ReservationTableListResponse;
import com.example.billiardclubapi.entity.ReservationTable;
import com.example.billiardclubapi.service.BilliardTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReservationTableMapper {
    private final BilliardTableService billiardTableService;
    private final BilliardTableMapper billiardTableMapper;

    public ReservationTable toEntity(ReservationTableRequest request) {
        return ReservationTable.builder()
                .amount(request.amount())
                .billiardTable(billiardTableService.getById(request.billiardTable()))
                .build();
    }

    public ReservationTableResponse toResponse(ReservationTable reservationTable) {
        return ReservationTableResponse.builder()
                .id(reservationTable.getId())
                .amount(reservationTable.getAmount())
                .billiardTable(billiardTableMapper.toResponse(reservationTable.getBilliardTable()))
                .build();
    }

    public ReservationTableListResponse toListResponse(List<ReservationTable> reservationTableList) {
        List<ReservationTableResponse> reservationTableResponseList = reservationTableList.stream()
                .map(this::toResponse)
                .toList();
        return ReservationTableListResponse.builder()
                .items(reservationTableResponseList)
                .build();
    }
}
