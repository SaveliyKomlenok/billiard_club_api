package com.example.billiardclubapi.controller;

import com.example.billiardclubapi.dto.request.manufacturer.ManufacturerRequest;
import com.example.billiardclubapi.dto.response.manufacturer.ManufacturerListResponse;
import com.example.billiardclubapi.dto.response.manufacturer.ManufacturerResponse;
import com.example.billiardclubapi.entity.Manufacturer;
import com.example.billiardclubapi.mapper.ManufacturerMapper;
import com.example.billiardclubapi.service.ManufacturerService;
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
@RequestMapping("/api/v1/carambol/manufacturers")
@SecurityRequirement(name = "BearerAuth")
public class ManufacturerController {
    private final ManufacturerService manufacturerService;
    private final ManufacturerMapper manufacturerMapper;

    @GetMapping
    public ResponseEntity<ManufacturerListResponse> getAll() {
        List<Manufacturer> manufacturerList = manufacturerService.getAll();
        return new ResponseEntity<>(manufacturerMapper.toListResponse(manufacturerList), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManufacturerResponse> getById(@PathVariable Long id) {
        Manufacturer manufacturer = manufacturerService.getById(id);
        return new ResponseEntity<>(manufacturerMapper.toResponse(manufacturer), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ManufacturerResponse> save(@RequestBody @Valid ManufacturerRequest request) {
        Manufacturer manufacturer = manufacturerService.save(manufacturerMapper.toEntity(request));
        return new ResponseEntity<>(manufacturerMapper.toResponse(manufacturer), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ManufacturerResponse> update(@PathVariable Long id, @RequestBody @Valid ManufacturerRequest request) {
        Manufacturer manufacturer = manufacturerService.update(manufacturerMapper.toEntity(id, request));
        return new ResponseEntity<>(manufacturerMapper.toResponse(manufacturer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        manufacturerService.delete(id);
        return ResponseEntity.ok(String.format("Manufacturer with id %d removed", id));
    }
}