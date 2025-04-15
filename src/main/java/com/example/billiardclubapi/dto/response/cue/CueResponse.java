package com.example.billiardclubapi.dto.response.cue;

import com.example.billiardclubapi.dto.response.cuetype.CueTypeResponse;
import com.example.billiardclubapi.dto.response.manufacturer.ManufacturerResponse;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record CueResponse(
        Long id,
        String name,
        BigDecimal price,
        Integer amount,
        String tipType,
        Integer amountOfParts,
        String material,
        Integer diameter,
        BigDecimal weight,
        BigDecimal length,
        String category,
        String description,
        CueTypeResponse cueType,
        ManufacturerResponse manufacturer
) {
}
