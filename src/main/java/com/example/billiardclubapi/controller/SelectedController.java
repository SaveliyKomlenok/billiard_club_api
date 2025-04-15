package com.example.billiardclubapi.controller;

import com.example.billiardclubapi.dto.response.selected.SelectedResponse; // Измените на нужный DTO
import com.example.billiardclubapi.entity.User;
import com.example.billiardclubapi.service.SelectedService; // Измените на нужный сервис
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/carambol/selected")
@SecurityRequirement(name = "BearerAuth")
public class SelectedController {
    private final SelectedService selectedService;

    @GetMapping
    public ResponseEntity<SelectedResponse> listOfSelected(Principal principal) {
        return new ResponseEntity<>(selectedService.getAll(getCurrentUser(principal).getId()), HttpStatus.OK);
    }

    private User getCurrentUser(Principal principal) {
        return (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
    }
}
