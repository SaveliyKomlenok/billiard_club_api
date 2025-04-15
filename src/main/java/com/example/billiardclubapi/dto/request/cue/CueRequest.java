package com.example.billiardclubapi.dto.request.cue;

import java.math.BigDecimal;

public record CueRequest(
        String name,
        Integer amount,
        BigDecimal price,
        String tipType,
        Integer amountOfParts,
        String material,
        Integer diameter,
        BigDecimal weight,
        BigDecimal length,
        String category,
        String description,
        String imagePath,
        Long manufacturer,
        Long cueType
) {
}
