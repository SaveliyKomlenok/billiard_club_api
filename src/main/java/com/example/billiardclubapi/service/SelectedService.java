package com.example.billiardclubapi.service;

import com.example.billiardclubapi.dto.response.selected.SelectedResponse;

public interface SelectedService {
    SelectedResponse getAll(Long userId);
}
