package com.example.billiardclubapi.controller;

import com.example.billiardclubapi.dto.request.selectedcue.SelectedCueRequest;
import com.example.billiardclubapi.dto.response.selectedcue.SelectedCueResponse;
import com.example.billiardclubapi.dto.response.selectedcue.SelectedCueListResponse;
import com.example.billiardclubapi.entity.SelectedCue;
import com.example.billiardclubapi.entity.User;
import com.example.billiardclubapi.mapper.SelectedCueMapper;
import com.example.billiardclubapi.service.SelectedCueService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/carambol/selected-cues")
@SecurityRequirement(name = "BearerAuth")
public class SelectedCueController {
    private final SelectedCueService selectedCueService;
    private final SelectedCueMapper selectedCueMapper;

    @GetMapping("/{id}")
    public ResponseEntity<SelectedCueResponse> getById(@PathVariable Long id) {
        SelectedCue selectedCue = selectedCueService.getById(id);
        return new ResponseEntity<>(selectedCueMapper.toResponse(selectedCue), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<SelectedCueListResponse> getAll(Principal principal) {
        List<SelectedCue> selectedCueList = selectedCueService.getAll(getCurrentUser(principal).getId());
        return new ResponseEntity<>(selectedCueMapper.toListResponse(selectedCueList), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SelectedCueResponse> save(@RequestBody @Valid SelectedCueRequest request, Principal principal) {
        SelectedCue selectedCue = selectedCueService.save(selectedCueMapper.toEntity(request, getCurrentUser(principal).getId()));
        return new ResponseEntity<>(selectedCueMapper.toResponse(selectedCue), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SelectedCueResponse> update(@PathVariable Long id, @RequestBody @Valid SelectedCueRequest request, Principal principal) {
        SelectedCue selectedCue = selectedCueService.update(selectedCueMapper.toEntity(id, request, getCurrentUser(principal).getId()));
        return new ResponseEntity<>(selectedCueMapper.toResponse(selectedCue), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        selectedCueService.delete(id);
        return ResponseEntity.ok(String.format("Selected cue with id %d removed", id));
    }

    private User getCurrentUser(Principal principal) {
        return (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
    }
}
