package com.example.billiardclubapi.mapper;

import com.example.billiardclubapi.dto.request.cue.CueRequest;
import com.example.billiardclubapi.dto.response.cue.CueListResponse;
import com.example.billiardclubapi.dto.response.cue.CueResponse;
import com.example.billiardclubapi.entity.Cue;
import com.example.billiardclubapi.service.CueTypeService;
import com.example.billiardclubapi.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CueMapper {
    private final CueTypeService cueTypeService;
    private final ManufacturerService manufacturerService;
    private final CueTypeMapper cueTypeMapper;
    private final ManufacturerMapper manufacturerMapper;

    public Cue toEntity(CueRequest request) {
        return Cue.builder()
                .name(request.name())
                .amount(request.amount())
                .price(request.price())
                .tipType(request.tipType())
                .amountOfParts(request.amountOfParts())
                .material(request.material())
                .diameter(request.diameter())
                .weight(request.weight())
                .length(request.length())
                .category(request.category())
                .description(request.description())
                .imagePath(request.imagePath())
                .manufacturer(manufacturerService.getById(request.manufacturer()))
                .cueType(cueTypeService.getById(request.cueType()))
                .build();
    }

    public Cue toEntity(Long id, CueRequest request) {
        return Cue.builder()
                .id(id)
                .name(request.name())
                .amount(request.amount())
                .price(request.price())
                .tipType(request.tipType())
                .amountOfParts(request.amountOfParts())
                .material(request.material())
                .diameter(request.diameter())
                .weight(request.weight())
                .length(request.length())
                .category(request.category())
                .description(request.description())
                .imagePath(request.imagePath())
                .manufacturer(manufacturerService.getById(request.manufacturer()))
                .cueType(cueTypeService.getById(request.cueType()))
                .build();
    }

    public CueResponse toResponse(Cue cue) {
        return CueResponse.builder()
                .id(cue.getId())
                .name(cue.getName())
                .amount(cue.getAmount())
                .price(cue.getPrice())
                .tipType(cue.getTipType())
                .amountOfParts(cue.getAmountOfParts())
                .material(cue.getMaterial())
                .diameter(cue.getDiameter())
                .weight(cue.getWeight())
                .length(cue.getLength())
                .category(cue.getCategory())
                .description(cue.getDescription())
                .manufacturer(manufacturerMapper.toResponse(cue.getManufacturer()))
                .cueType(cueTypeMapper.toResponse(cue.getCueType()))
                .build();
    }

    public CueListResponse toListResponse(List<Cue> cueList) {
        List<CueResponse> cueResponseList = cueList.stream()
                .map(this::toResponse)
                .toList();
        return CueListResponse.builder()
                .items(cueResponseList)
                .build();
    }
}