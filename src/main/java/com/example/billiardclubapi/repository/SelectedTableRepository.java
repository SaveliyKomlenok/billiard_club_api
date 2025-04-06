package com.example.billiardclubapi.repository;

import com.example.billiardclubapi.entity.SelectedTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SelectedTableRepository extends JpaRepository<SelectedTable, Long> {
    List<SelectedTable> findSelectedTablesByUserId(Long userId);

    Optional<SelectedTable> findSelectedTableByBilliardTableIdAndUserId(Long billiardTableId, Long userId);

    void deleteAllByUserId(Long userId);
}
