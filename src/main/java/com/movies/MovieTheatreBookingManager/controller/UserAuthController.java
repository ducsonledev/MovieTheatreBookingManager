package com.movies.MovieTheatreBookingManager.controller;

import com.movies.MovieTheatreBookingManager.auth.AuthenticationService;
import com.movies.MovieTheatreBookingManager.dto.AuthenticationRequest;
import com.movies.MovieTheatreBookingManager.dto.AuthenticationResponse;
import com.movies.MovieTheatreBookingManager.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserAuthController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @GetMapping
    public String welcome(Model model) {
        return "welcome";
    }
}
