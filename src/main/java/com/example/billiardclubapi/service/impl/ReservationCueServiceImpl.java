package com.example.billiardclubapi.service.impl;

import com.example.billiardclubapi.entity.ReservationCue;
import com.example.billiardclubapi.entity.Cue;
import com.example.billiardclubapi.repository.ReservationCueRepository;
import com.example.billiardclubapi.service.ReservationCueService;
import com.example.billiardclubapi.service.CueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationCueServiceImpl implements ReservationCueService {
    private final ReservationCueRepository reservationCueRepository;
    private final CueService cueService;

    @Override
    public List<ReservationCue> getAll(Long reservationId) {
        return reservationCueRepository.findReservationCuesByReservationId(reservationId);
    }

    @Transactional
    @Override
    public ReservationCue save(ReservationCue reservationCue) {
        changeAmountAfterReserve(reservationCue.getCue(), reservationCue.getAmount());
        return reservationCueRepository.save(reservationCue);
    }

    @Override
    public void returnReservationCuesByReservationId(Long reservationId) {
        rollbackAmountOfCues(reservationId);
    }

    private void rollbackAmountOfCues(Long id) {
        for (ReservationCue reservationCue : reservationCueRepository.findReservationCuesByReservationId(id)) {
            changeAmountAfterCancelReserve(reservationCue.getCue(), reservationCue.getAmount());
        }
    }

    private void changeAmountAfterReserve(Cue cue, Integer amount) {
        cue.setAmount(cue.getAmount() - amount);
        cueService.update(cue);
    }

    private void changeAmountAfterCancelReserve(Cue cue, Integer amount) {
        cue.setAmount(cue.getAmount() + amount);
        cueService.update(cue);
    }
}