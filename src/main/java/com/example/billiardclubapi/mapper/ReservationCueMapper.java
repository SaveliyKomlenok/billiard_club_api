package com.example.billiardclubapi.mapper;

import com.example.billiardclubapi.dto.request.reservationcue.ReservationCueRequest;
import com.example.billiardclubapi.dto.response.reservationcue.ReservationCueResponse;
import com.example.billiardclubapi.dto.response.reservationcue.ReservationCueListResponse;
import com.example.billiardclubapi.entity.ReservationCue;
import com.example.billiardclubapi.service.CueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReservationCueMapper {
    private final CueService cueService;
    private final CueMapper cueMapper;

    public ReservationCue toEntity(ReservationCueRequest request) {
        return ReservationCue.builder()
                .amount(request.amount())
                .cue(cueService.getById(request.cue()))
                .build();
    }

    public ReservationCueResponse toResponse(ReservationCue reservationCue) {
        return ReservationCueResponse.builder()
                .id(reservationCue.getId())
                .amount(reservationCue.getAmount())
                .cue(cueMapper.toResponse(reservationCue.getCue()))
                .build();
    }

    public ReservationCueListResponse toListResponse(List<ReservationCue> reservationCueList) {
        List<ReservationCueResponse> reservationCueResponseList = reservationCueList.stream()
                .map(this::toResponse)
                .toList();
        return ReservationCueListResponse.builder()
                .items(reservationCueResponseList)
                .build();
    }
}
