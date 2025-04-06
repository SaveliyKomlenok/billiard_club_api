package com.example.billiardclubapi.controller;

import com.example.billiardclubapi.dto.request.cue.CueRequest;
import com.example.billiardclubapi.dto.response.cue.CueListResponse;
import com.example.billiardclubapi.dto.response.cue.CueResponse;
import com.example.billiardclubapi.entity.Cue;
import com.example.billiardclubapi.mapper.CueMapper;
import com.example.billiardclubapi.service.CueService;
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
@RequestMapping("/api/v1/carambol/cues")
//@SecurityRequirement(name = "BearerAuth")
public class CueController {
    private final CueService cueService;
    private final CueMapper cueMapper;
    private final ImageService imageService;

    @GetMapping
    public ResponseEntity<CueListResponse> getAll() {
        List<Cue> cueList = cueService.getAll();
        return new ResponseEntity<>(cueMapper.toListResponse(cueList), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CueResponse> getById(@PathVariable Long id) {
        Cue cue = cueService.getById(id);
        return new ResponseEntity<>(cueMapper.toResponse(cue), HttpStatus.OK);
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getCueImage(@PathVariable Long id) {
        String imagePath = cueService.getImagePath(id);
        byte[] imageBytes = imageService.getImage(imagePath);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(imageBytes);
    }

    @PostMapping
    public ResponseEntity<CueResponse> save(@RequestBody @Valid CueRequest request) {
        Cue cue = cueService.save(cueMapper.toEntity(request));
        return new ResponseEntity<>(cueMapper.toResponse(cue), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CueResponse> update(@PathVariable Long id, @RequestBody @Valid CueRequest request) {
        Cue cue = cueService.update(cueMapper.toEntity(id, request));
        return new ResponseEntity<>(cueMapper.toResponse(cue), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        cueService.delete(id);
        return ResponseEntity.ok(String.format("Cue with id %d removed", id));
    }
}
