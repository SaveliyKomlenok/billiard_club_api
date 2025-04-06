package com.example.billiardclubapi.controller;

import com.example.billiardclubapi.dto.request.billiardtabletype.BilliardTableTypeRequest;
import com.example.billiardclubapi.dto.response.billiardtabletype.BilliardTableTypeListResponse;
import com.example.billiardclubapi.dto.response.billiardtabletype.BilliardTableTypeResponse;
import com.example.billiardclubapi.entity.BilliardTableType;
import com.example.billiardclubapi.mapper.BilliardTableTypeMapper;
import com.example.billiardclubapi.service.BilliardTableTypeService;
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
@RequestMapping("/api/v1/carambol/billiard-table-types")
//@SecurityRequirement(name = "BearerAuth")
public class BilliardTableTypeController {
    private final BilliardTableTypeService billiardTableTypeService;
    private final BilliardTableTypeMapper billiardTableTypeMapper;

    @GetMapping
    public ResponseEntity<BilliardTableTypeListResponse> getAll() {
        List<BilliardTableType> billiardTableTypeList = billiardTableTypeService.getAll();
        return new ResponseEntity<>(billiardTableTypeMapper.toListResponse(billiardTableTypeList), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BilliardTableTypeResponse> getById(@PathVariable Long id) {
        BilliardTableType billiardTableType = billiardTableTypeService.getById(id);
        return new ResponseEntity<>(billiardTableTypeMapper.toResponse(billiardTableType), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BilliardTableTypeResponse> save(@RequestBody @Valid BilliardTableTypeRequest request) {
        BilliardTableType billiardTableType = billiardTableTypeService.save(billiardTableTypeMapper.toEntity(request));
        return new ResponseEntity<>(billiardTableTypeMapper.toResponse(billiardTableType), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BilliardTableTypeResponse> update(@PathVariable Long id, @RequestBody @Valid BilliardTableTypeRequest request) {
        BilliardTableType billiardTableType = billiardTableTypeService.update(billiardTableTypeMapper.toEntity(id, request));
        return new ResponseEntity<>(billiardTableTypeMapper.toResponse(billiardTableType), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        billiardTableTypeService.delete(id);
        return ResponseEntity.ok(String.format("BilliardTableType with id %d removed", id));
    }
}