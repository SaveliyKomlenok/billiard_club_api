package com.example.billiardclubapi.controller;

import com.example.billiardclubapi.dto.request.user.UserAuthenticateRequest;
import com.example.billiardclubapi.dto.request.user.UserRegisterRequest;
import com.example.billiardclubapi.dto.response.auth.AuthenticationResponse;
import com.example.billiardclubapi.mapper.UserMapper;
import com.example.billiardclubapi.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/carambol/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserMapper userMapper;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UserRegisterRequest request) {
        return new ResponseEntity<>(authenticationService.register(userMapper.toEntity(request)), HttpStatus.CREATED);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody UserAuthenticateRequest request) {
        return new ResponseEntity<>(authenticationService.authenticate(userMapper.toEntity(request)), HttpStatus.OK);
    }
}