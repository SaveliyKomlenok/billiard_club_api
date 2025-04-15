package com.example.billiardclubapi.service;

import com.example.billiardclubapi.entity.ReservationTable;

import java.util.List;

public interface ReservationTableService {
    List<ReservationTable> getAll(Long reservationId);
    ReservationTable save(ReservationTable reservationTable);
    void returnReservationTablesByReservationId(Long reservationId);
}
