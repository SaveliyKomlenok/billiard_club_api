package com.example.billiardclubapi.service;

import com.example.billiardclubapi.entity.Reservation;

import java.math.BigDecimal;
import java.util.List;

public interface ReservationService {
    List<Reservation> getAll(Long userId);
    Reservation save(Reservation reservation);
    Reservation cancel(Long id);
    void completeReservations();
    BigDecimal getTotalPrice(Long userId, int amountOfQuartersOfHour);
}
