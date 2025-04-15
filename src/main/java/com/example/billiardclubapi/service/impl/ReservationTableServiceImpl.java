package com.example.billiardclubapi.service.impl;

import com.example.billiardclubapi.entity.ReservationTable;
import com.example.billiardclubapi.entity.BilliardTable; // Предполагается, что этот класс существует
import com.example.billiardclubapi.repository.ReservationTableRepository; // Предполагается, что этот репозиторий существует
import com.example.billiardclubapi.service.ReservationTableService;
import com.example.billiardclubapi.service.BilliardTableService; // Предполагается, что этот сервис существует
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationTableServiceImpl implements ReservationTableService {
    private final ReservationTableRepository reservationTableRepository;
    private final BilliardTableService billiardTableService;

    @Override
    public List<ReservationTable> getAll(Long reservationId) {
        return reservationTableRepository.findReservationTablesByReservationId(reservationId);
    }

    @Transactional
    @Override
    public ReservationTable save(ReservationTable reservationTable) {
        changeAmountAfterReserve(reservationTable.getBilliardTable(), reservationTable.getAmount());
        return reservationTableRepository.save(reservationTable);
    }

    @Override
    public void returnReservationTablesByReservationId(Long reservationId) {
        rollbackAmountOfTables(reservationId);
    }

    private void rollbackAmountOfTables(Long id) {
        for (ReservationTable reservationTable : reservationTableRepository.findReservationTablesByReservationId(id)) {
            changeAmountAfterCancelReserve(reservationTable.getBilliardTable(), reservationTable.getAmount());
        }
    }

    private void changeAmountAfterReserve(BilliardTable table, Integer amount) {
        table.setAmount(table.getAmount() - amount);
        billiardTableService.update(table);
    }

    private void changeAmountAfterCancelReserve(BilliardTable table, Integer amount) {
        table.setAmount(table.getAmount() + amount);
        billiardTableService.update(table);
    }
}