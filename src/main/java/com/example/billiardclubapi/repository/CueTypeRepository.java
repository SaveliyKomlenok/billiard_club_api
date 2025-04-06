package com.example.billiardclubapi.repository;

import com.example.billiardclubapi.entity.CueType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CueTypeRepository extends JpaRepository<CueType, Long> {
}
