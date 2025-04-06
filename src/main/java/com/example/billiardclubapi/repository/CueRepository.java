package com.example.billiardclubapi.repository;

import com.example.billiardclubapi.entity.Cue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CueRepository extends JpaRepository<Cue, Long> {
}
