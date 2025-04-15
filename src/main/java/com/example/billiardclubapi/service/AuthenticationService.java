package com.example.billiardclubapi.service;

import com.example.billiardclubapi.dto.response.auth.AuthenticationResponse;
import com.example.billiardclubapi.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(User user) {
        User newUser = userService.save(user);
        var jwtToken = jwtService.generateToken(newUser);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .username(newUser.getUsername())
                .role(newUser.getRole().toString())
                .build();
    }

    public AuthenticationResponse authenticate(User user) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );
        var authUser = userService.getByUsername(user.getUsername());
        var jwtToken = jwtService.generateToken(authUser);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .username(authUser.getUsername())
                .role(authUser.getRole().toString())
                .build();
    }
}
