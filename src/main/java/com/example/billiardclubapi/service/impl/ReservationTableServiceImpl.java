package com.example.billiardclubapi.service.impl;

import com.example.billiardclubapi.entity.ReservationTable;
import com.example.billiardclubapi.service.ReservationTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationTableServiceImpl implements ReservationTableService {
    @Override
    public List<ReservationTable> getAll(Long reservationId) {
        return null;
    }

    @Override
    public ReservationTable save(ReservationTable reservationTable) {
        return null;
    }

    @Override
    public void deleteReservationTablesByReservationId(Long reservationId) {

    }
}
