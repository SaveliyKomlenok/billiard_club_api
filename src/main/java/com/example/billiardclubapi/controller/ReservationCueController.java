package com.example.billiardclubapi.controller;

import com.example.billiardclubapi.dto.response.reservationcue.ReservationCueListResponse;
import com.example.billiardclubapi.entity.ReservationCue;
import com.example.billiardclubapi.mapper.ReservationCueMapper;
import com.example.billiardclubapi.service.ReservationCueService;
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
@RequestMapping("/api/v1/carambol/reservation-cues")
@SecurityRequirement(name = "BearerAuth")
public class ReservationCueController {
    private final ReservationCueService reservationCueService;
    private final ReservationCueMapper reservationCueMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ReservationCueListResponse> findAllById(@PathVariable("id") Long id) {
        List<ReservationCue> reservationCueList = reservationCueService.getAll(id);
        return new ResponseEntity<>(reservationCueMapper.toListResponse(reservationCueList), HttpStatus.OK);
    }
}
