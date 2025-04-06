package com.example.billiardclubapi.service.impl;

import com.example.billiardclubapi.entity.Reservation;
import com.example.billiardclubapi.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService  {
    @Override
    public List<Reservation> getAll(Long userId) {
        return null;
    }

    @Override
    public Reservation save(Reservation reservation) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
