package com.example.billiardclubapi.controller;

import com.example.billiardclubapi.dto.request.billiardtable.BilliardTableRequest;
import com.example.billiardclubapi.dto.response.billiardtable.BilliardTableListResponse;
import com.example.billiardclubapi.dto.response.billiardtable.BilliardTableResponse;
import com.example.billiardclubapi.entity.BilliardTable;
import com.example.billiardclubapi.mapper.BilliardTableMapper;
import com.example.billiardclubapi.service.BilliardTableService;
import com.example.billiardclubapi.service.ImageService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
@RequestMapping("/api/v1/carambol/billiard-tables")
@SecurityRequirement(name = "BearerAuth")
public class BilliardTableController {
    private final BilliardTableService billiardTableService;
    private final BilliardTableMapper billiardTableMapper;
    private final ImageService imageService;

    @GetMapping
    public ResponseEntity<BilliardTableListResponse> getAll() {
        List<BilliardTable> billiardTableList = billiardTableService.getAll();
        return new ResponseEntity<>(billiardTableMapper.toListResponse(billiardTableList), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BilliardTableResponse> getById(@PathVariable Long id) {
        BilliardTable billiardTable = billiardTableService.getById(id);
        return new ResponseEntity<>(billiardTableMapper.toResponse(billiardTable), HttpStatus.OK);
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getBilliardTableImage(@PathVariable Long id) {
        String imagePath = billiardTableService.getImagePath(id);
        byte[] imageBytes = imageService.getImage(imagePath);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(imageBytes);
    }

    @PostMapping
    public ResponseEntity<BilliardTableResponse> save(@RequestBody @Valid BilliardTableRequest request) {
        BilliardTable billiardTable = billiardTableService.save(billiardTableMapper.toEntity(request));
        return new ResponseEntity<>(billiardTableMapper.toResponse(billiardTable), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BilliardTableResponse> update(@PathVariable Long id, @RequestBody @Valid BilliardTableRequest request) {
        BilliardTable billiardTable = billiardTableService.update(billiardTableMapper.toEntity(id, request));
        return new ResponseEntity<>(billiardTableMapper.toResponse(billiardTable), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        billiardTableService.delete(id);
        return ResponseEntity.ok(String.format("BilliardTable with id %d removed", id));
    }
}