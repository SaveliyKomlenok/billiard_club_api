package com.example.billiardclubapi.dto.request.billiardtable;

import com.example.billiardclubapi.enumiration.NumberOfPockets;

public record BilliardTableRequest(
        String name,
        Integer amount,
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
