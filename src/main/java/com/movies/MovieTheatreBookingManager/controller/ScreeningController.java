package com.movies.MovieTheatreBookingManager.controller;

import com.movies.MovieTheatreBookingManager.repositories.MovieRepository;
import com.movies.MovieTheatreBookingManager.services.ScreeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/screenings")
@RequiredArgsConstructor
public class ScreeningController {

    private final MovieRepository movieRepository;
    private final ScreeningService screeningService;

    @GetMapping
    public ResponseEntity<String> getScreenings() {
        return ResponseEntity.ok("screenings");
    }
}
