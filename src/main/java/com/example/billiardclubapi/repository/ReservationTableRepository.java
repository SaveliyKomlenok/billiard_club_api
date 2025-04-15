package com.example.billiardclubapi.repository;

import com.example.billiardclubapi.entity.ReservationTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationTableRepository extends JpaRepository<ReservationTable, Long> {
    List<ReservationTable> findReservationTablesByReservationId(Long reservationId);
}
