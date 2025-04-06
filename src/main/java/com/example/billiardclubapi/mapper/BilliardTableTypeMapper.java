package com.example.billiardclubapi.mapper;

import com.example.billiardclubapi.dto.request.billiardtabletype.BilliardTableTypeRequest;
import com.example.billiardclubapi.dto.response.billiardtabletype.BilliardTableTypeListResponse;
import com.example.billiardclubapi.dto.response.billiardtabletype.BilliardTableTypeResponse;
import com.example.billiardclubapi.entity.BilliardTableType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BilliardTableTypeMapper {
    public BilliardTableType toEntity(BilliardTableTypeRequest request) {
        return BilliardTableType.builder()
                .name(request.name())
                .build();
    }

    public BilliardTableType toEntity(Long id, BilliardTableTypeRequest request) {
        return BilliardTableType.builder()
                .id(id)
                .name(request.name())
                .build();
    }

    public BilliardTableTypeResponse toResponse(BilliardTableType billiardTableType) {
        return BilliardTableTypeResponse.builder()
                .id(billiardTableType.getId())
                .name(billiardTableType.getName())
                .build();
    }

    public BilliardTableTypeListResponse toListResponse(List<BilliardTableType> billiardTableTypeList) {
        List<BilliardTableTypeResponse> billiardTableTypeResponseList = billiardTableTypeList.stream()
                .map(this::toResponse)
                .toList();
        return BilliardTableTypeListResponse.builder()
                .items(billiardTableTypeResponseList)
                .build();
    }
}
