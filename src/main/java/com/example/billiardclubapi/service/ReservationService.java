package com.example.billiardclubapi.service;

import com.example.billiardclubapi.entity.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAll(Long userId);
    Reservation save(Reservation reservation);
    void delete(Long id);
}
