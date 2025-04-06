package com.example.billiardclubapi.service;

import com.example.billiardclubapi.entity.BilliardTableType;

import java.util.List;

public interface BilliardTableTypeService {
    BilliardTableType getById(Long id);
    List<BilliardTableType> getAll();
    BilliardTableType save(BilliardTableType billiardTableType);
    BilliardTableType update(BilliardTableType billiardTableType);
    void delete(Long id);
}
