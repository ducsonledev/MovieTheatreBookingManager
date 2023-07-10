package com.movies.MovieTheatreBookingManager.controller;

import com.movies.MovieTheatreBookingManager.domain.MovieScreening;
import com.movies.MovieTheatreBookingManager.repositories.MovieRepository;
import com.movies.MovieTheatreBookingManager.services.ScreeningService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/screenings")
@RequiredArgsConstructor
@Validated
public class ScreeningController {

    private final MovieRepository movieRepository;
    private final ScreeningService screeningService;

    @GetMapping("/{movie}")
    public ResponseEntity<String> getScreenings(@RequestParam String movie, Model model) {
        List<MovieScreening> result = screeningService.getMovieScreeningsByMovie(movie);
        model.addAttribute("screenings", result);
        model.addAttribute("movie", movieRepository.findByMovieName(movie));

        return ResponseEntity.ok("screenings");
    }

    @PostMapping
    public String bookSeats(@Valid @ModelAttribute MovieScreening movieBooking) {

        return "res";
    }
}
