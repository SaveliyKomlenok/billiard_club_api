package com.example.billiardclubapi.repository;

import com.example.billiardclubapi.entity.BilliardTableType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BilliardTableTypeRepository extends JpaRepository<BilliardTableType, Long> {
}
