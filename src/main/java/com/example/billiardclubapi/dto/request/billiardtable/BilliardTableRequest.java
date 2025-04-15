package com.example.billiardclubapi.dto.request.billiardtable;

import com.example.billiardclubapi.enumiration.NumberOfPockets;

import java.math.BigDecimal;

public record BilliardTableRequest(
        String name,
        Integer amount,
        BigDecimal price,
        String size,
        String sizeOfPockets,
        String frameMaterial,
        String clothMaterial,
        String clothColor,
        NumberOfPockets numberOfPockets,
        String description,
        String imagePath,
        Long manufacturer,
        Long billiardTableType
) {
}
