package com.example.billiardclubapi.dto.response.billiardtable;

import com.example.billiardclubapi.dto.response.billiardtabletype.BilliardTableTypeResponse;
import com.example.billiardclubapi.dto.response.manufacturer.ManufacturerResponse;
import com.example.billiardclubapi.enumiration.NumberOfPockets;
import lombok.Builder;

@Builder
public record BilliardTableResponse(
        Long id,
        String name,
        Integer amount,
        String size,
        String sizeOfPockets,
        String frameMaterial,
        String clothMaterial,
        String clothColor,
        NumberOfPockets numberOfPockets,
        String description,
        boolean isReserved,
        ManufacturerResponse manufacturer,
        BilliardTableTypeResponse billiardTableType
) {
}
