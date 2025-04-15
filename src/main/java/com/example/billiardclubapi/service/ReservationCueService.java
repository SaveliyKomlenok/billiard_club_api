package com.example.billiardclubapi.service;

import com.example.billiardclubapi.entity.ReservationCue;

import java.util.List;

public interface ReservationCueService {
    List<ReservationCue> getAll(Long reservationId);
    ReservationCue save(ReservationCue reservationCue);
    void returnReservationCuesByReservationId(Long reservationId);
}
