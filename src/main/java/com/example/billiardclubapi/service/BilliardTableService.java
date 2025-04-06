package com.example.billiardclubapi.service;

import com.example.billiardclubapi.entity.BilliardTable;

import java.util.List;

public interface BilliardTableService {
    BilliardTable getById(Long id);
    List<BilliardTable> getAll();
    BilliardTable save(BilliardTable billiardTable);
    BilliardTable update(BilliardTable billiardTable);
    void delete(Long id);
    String getImagePath(Long id);
}
