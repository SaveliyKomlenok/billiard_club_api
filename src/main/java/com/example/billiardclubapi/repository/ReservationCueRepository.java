package com.example.billiardclubapi.repository;

import com.example.billiardclubapi.entity.ReservationCue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationCueRepository extends JpaRepository<ReservationCue, Long> {
    List<ReservationCue> findReservationCuesByReservationId(Long reservationId);

    void deleteReservationCuesByReservationId(Long reservationId);
}
