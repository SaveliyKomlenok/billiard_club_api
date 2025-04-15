package com.example.billiardclubapi.service.impl;

import com.example.billiardclubapi.dto.response.selected.SelectedResponse;
import com.example.billiardclubapi.mapper.SelectedMapper;
import com.example.billiardclubapi.service.SelectedCueService;
import com.example.billiardclubapi.service.SelectedService;
import com.example.billiardclubapi.service.SelectedTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class SelectedServiceImpl implements SelectedService {
    private final SelectedCueService selectedCueService;
    private final SelectedTableService selectedTableService;
    private final SelectedMapper selectedMapper;

    @Override
    public SelectedResponse getAll(Long userId) {
        return selectedMapper.toResponse(selectedCueService.getAll(userId), selectedTableService.getAll(userId));
    }
}
