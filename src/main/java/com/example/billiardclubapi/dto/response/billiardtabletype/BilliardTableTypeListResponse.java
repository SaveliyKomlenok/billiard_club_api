package com.example.billiardclubapi.dto.response.billiardtabletype;

import lombok.Builder;

import java.util.List;

@Builder
public record BilliardTableTypeListResponse(
        List<BilliardTableTypeResponse> items
) {
}
