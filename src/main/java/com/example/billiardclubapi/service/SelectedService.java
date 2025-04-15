package com.example.billiardclubapi.service;

import com.example.billiardclubapi.dto.response.selected.SelectedResponse;

import java.math.BigDecimal;

public interface SelectedService {
    SelectedResponse getAll(Long userId);
}
