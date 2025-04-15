package com.example.billiardclubapi.mapper;

import com.example.billiardclubapi.dto.request.reservation.ReservationRequest;
import com.example.billiardclubapi.dto.response.reservation.ReservationResponse;
import com.example.billiardclubapi.dto.response.reservation.ReservationListResponse;
import com.example.billiardclubapi.entity.BilliardTable;
import com.example.billiardclubapi.entity.Reservation;
import com.example.billiardclubapi.entity.ReservationCue;
import com.example.billiardclubapi.entity.ReservationTable;
import com.example.billiardclubapi.enumiration.ReservationStatus;
import com.example.billiardclubapi.service.ReservationCueService;
import com.example.billiardclubapi.service.ReservationTableService;
import com.example.billiardclubapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReservationMapper {
    private final UserService userService;
    private final UserMapper userMapper;
    private final ReservationCueMapper reservationCueMapper;
    private final ReservationTableMapper reservationTableMapper;
    private final ReservationCueService reservationCueService;
    private final ReservationTableService reservationTableService;

    public Reservation toEntity(ReservationRequest request, Long userId) {
        return Reservation.builder()
                .address(request.address())
                .reservationDate(request.reservationDate())
                .reservationTime(request.reservationTime())
                .durationHours(request.durationHours())
                .user(userService.getById(userId))
                .status(ReservationStatus.CREATED)
                .build();
    }

    public ReservationResponse toResponse(Reservation reservation) {
        return ReservationResponse.builder()
                .id(reservation.getId())
                .address(reservation.getAddress())
                .startReservationDate(String.valueOf(reservation.getReservationTime()))
                .endReservationDate(String.valueOf(reservation.getReservationTime().plusHours(reservation.getDurationHours())))
                .status(String.valueOf(reservation.getStatus()))
                .user(userMapper.toResponse(reservation.getUser()))
                .createdAt(String.valueOf(reservation.getCreatedAt()))
                .totalPrice(reservation.getTotalPrice())
                .reservedCues(reservationCueService.getAll(reservation.getUser().getId()).stream()
                        .map(reservationCueMapper::toResponse).toList())
                .reservedBilliardTables(reservationTableService.getAll(reservation.getUser().getId()).stream()
                        .map(reservationTableMapper::toResponse).toList())
                .build();
    }

    public ReservationListResponse toListResponse(List<Reservation> reservationList) {
        List<ReservationResponse> reservationResponseList = reservationList.stream()
                .map(this::toResponse)
                .toList();
        return ReservationListResponse.builder()
                .items(reservationResponseList)
                .build();
    }
}
