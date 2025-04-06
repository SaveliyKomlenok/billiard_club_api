package com.example.billiardclubapi.service;

import com.example.billiardclubapi.entity.SelectedCue;

import java.util.List;

public interface SelectedCueService {
    SelectedCue getById(Long id);
    List<SelectedCue> getAll(Long userId);
    SelectedCue save(SelectedCue selectedCue);
    SelectedCue update(SelectedCue selectedCue);
    void delete(Long id);
    void deleteSelectedCuesByUserId(Long userId);
}
