package com.example.billiardclubapi.dto.response.manufacturer;

import lombok.Builder;

import java.util.List;

@Builder
public record ManufacturerListResponse(
        List<ManufacturerResponse> items
) {
}
