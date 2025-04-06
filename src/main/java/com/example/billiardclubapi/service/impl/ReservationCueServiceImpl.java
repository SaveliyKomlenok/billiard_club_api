package com.example.billiardclubapi.service.impl;

import com.example.billiardclubapi.entity.ReservationCue;
import com.example.billiardclubapi.service.ReservationCueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationCueServiceImpl implements ReservationCueService {
    @Override
    public List<ReservationCue> getAll(Long reservationId) {
        return null;
    }

    @Override
    public ReservationCue save(ReservationCue reservationCue) {
        return null;
    }

    @Override
    public void deleteReservationCuesByReservationId(Long reservationId) {

    }
}
