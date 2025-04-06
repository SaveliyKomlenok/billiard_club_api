package com.example.billiardclubapi.dto.response.billiardtable;

import lombok.Builder;

import java.util.List;

@Builder
public record BilliardTableListResponse(
        List<BilliardTableResponse> items
) {
}
