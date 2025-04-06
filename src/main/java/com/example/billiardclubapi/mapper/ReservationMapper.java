package com.example.billiardclubapi.mapper;

import com.example.billiardclubapi.dto.request.reservation.ReservationRequest;
import com.example.billiardclubapi.dto.response.reservation.ReservationResponse;
import com.example.billiardclubapi.dto.response.reservation.ReservationListResponse;
import com.example.billiardclubapi.entity.Reservation;
import com.example.billiardclubapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReservationMapper {
    private final UserService userService;
    private final UserMapper userMapper;

    public Reservation toEntity(ReservationRequest request, Long userId) {
        return Reservation.builder()
                .address(request.address())
                .reservationDate(request.reservationDate())
                .reservationTime(request.reservationTime())
                .durationHours(request.durationHours())
                .user(userService.getById(userId))
                .build();
    }

    public ReservationResponse toResponse(Reservation reservation) {
        return ReservationResponse.builder()
                .id(reservation.getId())
                .createdAt(reservation.getCreatedAt())
                .address(reservation.getAddress())
                .startReservationDate(String.valueOf(reservation.getReservationDate()))
                .endReservationDate(String.valueOf(reservation.getReservationDate().plusHours(reservation.getDurationHours())))
                .durationHours(reservation.getDurationHours())
                .user(userMapper.toResponse(reservation.getUser()))
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
