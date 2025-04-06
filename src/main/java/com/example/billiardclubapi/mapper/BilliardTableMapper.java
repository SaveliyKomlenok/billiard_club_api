package com.example.billiardclubapi.mapper;

import com.example.billiardclubapi.dto.request.billiardtable.BilliardTableRequest;
import com.example.billiardclubapi.dto.response.billiardtable.BilliardTableListResponse;
import com.example.billiardclubapi.dto.response.billiardtable.BilliardTableResponse;
import com.example.billiardclubapi.entity.BilliardTable;
import com.example.billiardclubapi.service.BilliardTableTypeService;
import com.example.billiardclubapi.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BilliardTableMapper {
    private final BilliardTableTypeService billiardTableTypeService;
    private final ManufacturerService manufacturerService;
    private final BilliardTableTypeMapper billiardTableTypeMapper;
    private final ManufacturerMapper manufacturerMapper;

    public BilliardTable toEntity(BilliardTableRequest request) {
        return BilliardTable.builder()
                .name(request.name())
                .amount(request.amount())
                .size(request.size())
                .sizeOfPockets(request.sizeOfPockets())
                .frameMaterial(request.frameMaterial())
                .clothMaterial(request.clothMaterial())
                .clothColor(request.clothColor())
                .numberOfPockets(request.numberOfPockets())
                .description(request.description())
                .imagePath(request.imagePath())
                .manufacturer(manufacturerService.getById(request.manufacturer()))
                .billiardTableType(billiardTableTypeService.getById(request.billiardTableType()))
                .build();
    }

    public BilliardTable toEntity(Long id, BilliardTableRequest request) {
        return BilliardTable.builder()
                .id(id)
                .name(request.name())
                .amount(request.amount())
                .size(request.size())
                .sizeOfPockets(request.sizeOfPockets())
                .frameMaterial(request.frameMaterial())
                .clothMaterial(request.clothMaterial())
                .clothColor(request.clothColor())
                .numberOfPockets(request.numberOfPockets())
                .description(request.description())
                .imagePath(request.imagePath())
                .manufacturer(manufacturerService.getById(request.manufacturer()))
                .billiardTableType(billiardTableTypeService.getById(request.billiardTableType()))
                .build();
    }

    public BilliardTableResponse toResponse(BilliardTable billiardTable) {
        return BilliardTableResponse.builder()
                .id(billiardTable.getId())
                .name(billiardTable.getName())
                .amount(billiardTable.getAmount())
                .size(billiardTable.getSize())
                .sizeOfPockets(billiardTable.getSizeOfPockets())
                .frameMaterial(billiardTable.getFrameMaterial())
                .clothMaterial(billiardTable.getClothMaterial())
                .clothColor(billiardTable.getClothColor())
                .numberOfPockets(billiardTable.getNumberOfPockets())
                .description(billiardTable.getDescription())
                .isReserved(billiardTable.isReserved())
                .manufacturer(manufacturerMapper.toResponse(billiardTable.getManufacturer()))
                .billiardTableType(billiardTableTypeMapper.toResponse(billiardTable.getBilliardTableType()))
                .build();
    }

    public BilliardTableListResponse toListResponse(List<BilliardTable> billiardTableList) {
        List<BilliardTableResponse> billiardTableResponseList = billiardTableList.stream()
                .map(this::toResponse)
                .toList();
        return BilliardTableListResponse.builder()
                .items(billiardTableResponseList)
                .build();
    }
}