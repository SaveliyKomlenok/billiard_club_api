package com.example.billiardclubapi.service;

import com.example.billiardclubapi.entity.Cue;

import java.util.List;

public interface CueService {
    Cue getById(Long id);
    List<Cue> getAll();
    Cue save(Cue Cue);
    Cue update(Cue Cue);
    void delete(Long id);
    String getImagePath(Long id);
}
