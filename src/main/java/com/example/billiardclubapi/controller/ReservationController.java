package com.example.billiardclubapi.controller;

import com.example.billiardclubapi.dto.request.reservation.ReservationRequest;
import com.example.billiardclubapi.dto.response.reservation.ReservationListResponse;
import com.example.billiardclubapi.dto.response.reservation.ReservationResponse;
import com.example.billiardclubapi.entity.Reservation;
import com.example.billiardclubapi.entity.User;
import com.example.billiardclubapi.mapper.ReservationMapper;
import com.example.billiardclubapi.service.ReservationService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/carambol/reservations")
@SecurityRequirement(name = "BearerAuth")
public class ReservationController {
    private final ReservationService reservationService;
    private final ReservationMapper reservationMapper;

    @GetMapping
    public ResponseEntity<ReservationListResponse> findAll(Principal principal) {
        List<Reservation> reservationList = reservationService.getAll(getCurrentUser(principal).getId());
        return new ResponseEntity<>(reservationMapper.toListResponse(reservationList), HttpStatus.OK);
    }

    @GetMapping("/active")
    public ResponseEntity<ReservationListResponse> findAllActiveReservations(Principal principal) {
        List<Reservation> reservationList = reservationService.getAllActiveReservations(getCurrentUser(principal).getId());
        return new ResponseEntity<>(reservationMapper.toListResponse(reservationList), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReservationResponse> create(@RequestBody ReservationRequest request, Principal principal) {
        Reservation reservation = reservationService.save(reservationMapper.toEntity(request, getCurrentUser(principal).getId()));
        return new ResponseEntity<>(reservationMapper.toResponse(reservation), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationResponse> cancel(@PathVariable("id") Long id) {
        Reservation reservation = reservationService.cancel(id);
        return new ResponseEntity<>(reservationMapper.toResponse(reservation), HttpStatus.OK);
    }

    private User getCurrentUser(Principal principal) {
        return (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
    }
}
