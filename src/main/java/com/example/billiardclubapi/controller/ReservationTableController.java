package com.example.billiardclubapi.controller;

import com.example.billiardclubapi.dto.response.reservationtable.ReservationTableListResponse;
import com.example.billiardclubapi.entity.ReservationTable;
import com.example.billiardclubapi.mapper.ReservationTableMapper;
import com.example.billiardclubapi.service.ReservationTableService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/carambol/reservation-tables")
//@SecurityRequirement(name = "BearerAuth")
public class ReservationTableController {
    private final ReservationTableService reservationTableService;
    private final ReservationTableMapper reservationTableMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ReservationTableListResponse> findAllById(@PathVariable("id") Long id) {
        List<ReservationTable> reservationTableList = reservationTableService.getAll(id);
        return new ResponseEntity<>(reservationTableMapper.toListResponse(reservationTableList), HttpStatus.OK);
    }
}
