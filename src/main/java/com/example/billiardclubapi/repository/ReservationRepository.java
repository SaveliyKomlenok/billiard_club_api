package com.example.billiardclubapi.repository;

import com.example.billiardclubapi.entity.Reservation;
import com.example.billiardclubapi.enumiration.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findReservationsByUserId(Long userId);

    List<Reservation> findReservationsByStatusEquals(ReservationStatus reservationStatus);
}
