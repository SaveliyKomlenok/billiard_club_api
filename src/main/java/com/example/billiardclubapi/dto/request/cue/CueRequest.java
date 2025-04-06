package com.example.billiardclubapi.dto.request.cue;

import java.math.BigDecimal;

public record CueRequest(
        String name,
        Integer amount,
        String tipType,
        String amountOfParts,
        String material,
        Integer diameter,
        BigDecimal weight,
        BigDecimal length,
        String brand,
        String category,
        String description,
        String imagePath,
        Long manufacturer,
        Long cueType
) {
}
