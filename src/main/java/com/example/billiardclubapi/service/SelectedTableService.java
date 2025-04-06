package com.example.billiardclubapi.service;

import com.example.billiardclubapi.entity.SelectedTable;

import java.util.List;

public interface SelectedTableService {
    SelectedTable getById(Long id);
    List<SelectedTable> getAll(Long userId);
    SelectedTable save(SelectedTable selectedTable);
    SelectedTable update(SelectedTable selectedTable);
    void delete(Long id);
    void deleteSelectedTablesByUserId(Long userId);
}
