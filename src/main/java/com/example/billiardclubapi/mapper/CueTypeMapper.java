package com.example.billiardclubapi.mapper;

import com.example.billiardclubapi.dto.request.cuetype.CueTypeRequest;
import com.example.billiardclubapi.dto.response.cuetype.CueTypeListResponse;
import com.example.billiardclubapi.dto.response.cuetype.CueTypeResponse;
import com.example.billiardclubapi.entity.CueType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CueTypeMapper {
    public CueType toEntity(CueTypeRequest request) {
        return CueType.builder()
                .name(request.name())
                .build();
    }

    public CueType toEntity(Long id, CueTypeRequest request) {
        return CueType.builder()
                .id(id)
                .name(request.name())
                .build();
    }

    public CueTypeResponse toResponse(CueType cueType) {
        return CueTypeResponse.builder()
                .id(cueType.getId())
                .name(cueType.getName())
                .build();
    }

    public CueTypeListResponse toListResponse(List<CueType> cueTypeList) {
        List<CueTypeResponse> cueTypeResponseList = cueTypeList.stream()
                .map(this::toResponse)
                .toList();
        return CueTypeListResponse.builder()
                .items(cueTypeResponseList)
                .build();
    }
}
