package com.example.billiardclubapi.controller;

import com.example.billiardclubapi.dto.request.cuetype.CueTypeRequest;
import com.example.billiardclubapi.dto.response.cuetype.CueTypeListResponse;
import com.example.billiardclubapi.dto.response.cuetype.CueTypeResponse;
import com.example.billiardclubapi.entity.CueType;
import com.example.billiardclubapi.mapper.CueTypeMapper;
import com.example.billiardclubapi.service.CueTypeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/carambol/cue-types")
//@SecurityRequirement(name = "BearerAuth")
public class CueTypeController {
    private final CueTypeService cueTypeService;
    private final CueTypeMapper cueTypeMapper;

    @GetMapping
    public ResponseEntity<CueTypeListResponse> getAll() {
        List<CueType> cueTypeList = cueTypeService.getAll();
        return new ResponseEntity<>(cueTypeMapper.toListResponse(cueTypeList), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CueTypeResponse> getById(@PathVariable Long id) {
        CueType cueType = cueTypeService.getById(id);
        return new ResponseEntity<>(cueTypeMapper.toResponse(cueType), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CueTypeResponse> save(@RequestBody @Valid CueTypeRequest request) {
        CueType cueType = cueTypeService.save(cueTypeMapper.toEntity(request));
        return new ResponseEntity<>(cueTypeMapper.toResponse(cueType), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CueTypeResponse> update(@PathVariable Long id, @RequestBody @Valid CueTypeRequest request) {
        CueType cueType = cueTypeService.update(cueTypeMapper.toEntity(id, request));
        return new ResponseEntity<>(cueTypeMapper.toResponse(cueType), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        cueTypeService.delete(id);
        return ResponseEntity.ok(String.format("CueType with id %d removed", id));
    }
}