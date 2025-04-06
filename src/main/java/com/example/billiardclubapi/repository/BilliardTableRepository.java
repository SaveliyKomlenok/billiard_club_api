package com.example.billiardclubapi.repository;

import com.example.billiardclubapi.entity.BilliardTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BilliardTableRepository extends JpaRepository<BilliardTable, Long> {
}
