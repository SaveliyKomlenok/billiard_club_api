package com.example.billiardclubapi.service.impl;

import com.example.billiardclubapi.entity.Reservation;
import com.example.billiardclubapi.entity.ReservationCue;
import com.example.billiardclubapi.entity.ReservationTable;
import com.example.billiardclubapi.entity.SelectedCue;
import com.example.billiardclubapi.entity.SelectedTable;
import com.example.billiardclubapi.enumiration.ReservationStatus;
import com.example.billiardclubapi.exception.ReserveNotExistException;
import com.example.billiardclubapi.repository.ReservationRepository;
import com.example.billiardclubapi.service.ReservationCueService;
import com.example.billiardclubapi.service.ReservationService;
import com.example.billiardclubapi.service.ReservationTableService;
import com.example.billiardclubapi.service.SelectedCueService;
import com.example.billiardclubapi.service.SelectedTableService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

import static com.example.billiardclubapi.util.Constants.AMOUNT_OF_PROCEED_RESERVATIONS;
import static com.example.billiardclubapi.util.ExceptionMessages.RESERVE_NOT_EXISTS;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final SelectedCueService selectedCueService;
    private final SelectedTableService selectedTableService;
    private final ReservationCueService reservationCueService;
    private final ReservationTableService reservationTableService;

    @Override
    public List<Reservation> getAll(Long userId) {
        return reservationRepository.findReservationsByUserId(userId).stream()
                .filter(reservation -> reservation.getStatus().equals(ReservationStatus.COMPLETED)
                                       || reservation.getStatus().equals(ReservationStatus.CANCELED))
                .toList();
    }

    @Override
    public List<Reservation> getAllActiveReservations(Long userId) {
        return reservationRepository.findReservationsByUserId(userId).stream()
                .filter(reservation -> reservation.getStatus().equals(ReservationStatus.CREATED))
                .toList();
    }

    @Transactional
    @Override
    public Reservation save(Reservation reservation) {
        reservation.setTotalPrice(getTotalPrice(reservation.getUser().getId(), reservation.getDurationHours() * 4));
        Reservation savedReservation = reservationRepository.save(reservation);
        mapSelectedToReservationCue(savedReservation);
        mapSelectedToReservationTable(savedReservation);
        return savedReservation;
    }

    @Transactional
    @Override
    public Reservation cancel(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ReserveNotExistException(String.format(RESERVE_NOT_EXISTS, id)));
        reservationCueService.returnReservationCuesByReservationId(reservation.getId());
        reservationTableService.returnReservationTablesByReservationId(reservation.getId());
        reservation.setStatus(ReservationStatus.CANCELED);
        return reservation;
    }

    @Transactional
    @Override
    public void completeReservations() {
        List<Reservation> completedByTimeReservations = reservationRepository
                .findReservationsByStatusEquals(ReservationStatus.CREATED).stream()
                .filter(reservation -> reservation.getReservationTime()
                        .plusHours(reservation.getDurationHours())
                        .isBefore(LocalDateTime.now()))
                .toList();

        log.info("Found {} completed reservations to process.", completedByTimeReservations.size());

        int processedCount = 0;
        for (Reservation reservation : completedByTimeReservations) {
            reservationCueService.returnReservationCuesByReservationId(reservation.getId());
            reservationTableService.returnReservationTablesByReservationId(reservation.getId());
            reservation.setStatus(ReservationStatus.COMPLETED);
            reservationRepository.save(reservation);
            log.info("Completing reservation ID: {}", reservation.getId());
            processedCount++;
        }

        log.info(String.format(AMOUNT_OF_PROCEED_RESERVATIONS, processedCount));
    }


    private void mapSelectedToReservationCue(Reservation reservation) {
        for (SelectedCue selectedCue : selectedCueService.getAll(reservation.getUser().getId())) {
            ReservationCue reservationCue = ReservationCue.builder()
                    .amount(selectedCue.getAmount())
                    .cue(selectedCue.getCue())
                    .reservation(reservation)
                    .build();
            reservationCueService.save(reservationCue);
        }
        selectedCueService.deleteSelectedCuesByUserId(reservation.getUser().getId());
    }

    private void mapSelectedToReservationTable(Reservation reservation) {
        for (SelectedTable selectedTable : selectedTableService.getAll(reservation.getUser().getId())) {
            ReservationTable reservationTable = ReservationTable.builder()
                    .amount(selectedTable.getAmount())
                    .billiardTable(selectedTable.getBilliardTable())
                    .reservation(reservation)
                    .build();
            reservationTableService.save(reservationTable);
        }
        selectedTableService.deleteSelectedTablesByUserId(reservation.getUser().getId());
    }

    @Override
    public BigDecimal getTotalPrice(Long userId, int amountOfQuartersOfHour) {
        return getTotalCuesPrice(userId).add(getTotalBilliardTablesPrice(userId, amountOfQuartersOfHour))
                .setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal getTotalCuesPrice(Long userId) {
        return selectedCueService.getAll(userId).stream()
                .map(selectedCue -> selectedCue.getCue().getPrice().multiply(BigDecimal.valueOf(selectedCue.getAmount())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal getTotalBilliardTablesPrice(Long userId, int amountOfQuartersOfHour) {
        return selectedTableService.getAll(userId).stream()
                .map(selectedTable -> selectedTable.getBilliardTable().getPrice().multiply(BigDecimal.valueOf(amountOfQuartersOfHour)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
