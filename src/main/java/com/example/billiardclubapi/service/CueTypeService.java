package com.example.billiardclubapi.service;

import com.example.billiardclubapi.entity.CueType;

import java.util.List;

public interface CueTypeService {
    CueType getById(Long id);
    List<CueType> getAll();
    CueType save(CueType cueType);
    CueType update(CueType cueType);
    void delete(Long id);
}
