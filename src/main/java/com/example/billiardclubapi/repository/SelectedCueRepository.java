package com.example.billiardclubapi.repository;

import com.example.billiardclubapi.entity.SelectedCue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SelectedCueRepository extends JpaRepository<SelectedCue, Long> {
    List<SelectedCue> findSelectedCuesByUserId(Long userId);

    Optional<SelectedCue> findSelectedCueByCueIdAndUserId(Long cueId, Long userId);

    void deleteAllByUserId(Long userId);
}
