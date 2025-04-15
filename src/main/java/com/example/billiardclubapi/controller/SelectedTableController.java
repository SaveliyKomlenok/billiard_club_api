package com.example.billiardclubapi.controller;

import com.example.billiardclubapi.dto.request.selectedtable.SelectedTableRequest;
import com.example.billiardclubapi.dto.response.selectedtable.SelectedTableResponse;
import com.example.billiardclubapi.dto.response.selectedtable.SelectedTableListResponse;
import com.example.billiardclubapi.entity.SelectedTable;
import com.example.billiardclubapi.entity.User;
import com.example.billiardclubapi.mapper.SelectedTableMapper;
import com.example.billiardclubapi.service.SelectedTableService;
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
@RequestMapping("/api/v1/carambol/selected-tables")
@SecurityRequirement(name = "BearerAuth")
public class SelectedTableController {
    private final SelectedTableService selectedTableService;
    private final SelectedTableMapper selectedTableMapper;

    @GetMapping("/{id}")
    public ResponseEntity<SelectedTableResponse> getById(@PathVariable Long id) {
        SelectedTable selectedTable = selectedTableService.getById(id);
        return new ResponseEntity<>(selectedTableMapper.toResponse(selectedTable), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<SelectedTableListResponse> getAll(Principal principal) {
        List<SelectedTable> selectedTableList = selectedTableService.getAll(getCurrentUser(principal).getId());
        return new ResponseEntity<>(selectedTableMapper.toListResponse(selectedTableList), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SelectedTableResponse> save(@RequestBody @Valid SelectedTableRequest request, Principal principal) {
        SelectedTable selectedTable = selectedTableService.save(selectedTableMapper.toEntity(request, getCurrentUser(principal).getId()));
        return new ResponseEntity<>(selectedTableMapper.toResponse(selectedTable), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SelectedTableResponse> update(@PathVariable Long id, @RequestBody @Valid SelectedTableRequest request, Principal principal) {
        SelectedTable selectedTable = selectedTableService.update(selectedTableMapper.toEntity(id, request, getCurrentUser(principal).getId()));
        return new ResponseEntity<>(selectedTableMapper.toResponse(selectedTable), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        selectedTableService.delete(id);
        return ResponseEntity.ok(String.format("Selected table with id %d removed", id));
    }

    private User getCurrentUser(Principal principal) {
        return (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
    }
}
