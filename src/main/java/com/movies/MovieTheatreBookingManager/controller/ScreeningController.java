package com.movies.MovieTheatreBookingManager.controller;

import com.movies.MovieTheatreBookingManager.domain.MovieScreening;
import com.movies.MovieTheatreBookingManager.repositories.MovieRepository;
import com.movies.MovieTheatreBookingManager.services.ScreeningService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/screenings")
@RequiredArgsConstructor
public class ScreeningController {
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(this.getClass());

    private final MovieRepository movieRepository;
    private final ScreeningService screeningService;

    @GetMapping("/{movie}")
    public String getScreenings(@RequestParam String movie, Model model) {
        List<MovieScreening> result = screeningService.getMovieScreeningsByMovie(movie);
        model.addAttribute("screenings", result);
        model.addAttribute("movie", movieRepository.findByMovieName(movie));

        return "screenings";
    }

    @PostMapping
    public String bookSeats(@Valid @ModelAttribute MovieScreening movieBooking) {
        LOGGER.info(movieBooking.getMovieName());
        LOGGER.info(movieBooking.getTheatreCity());
        LOGGER.info(movieBooking.getTheatreName());
        LOGGER.info(movieBooking.getScreeningTime());
        LOGGER.info(movieBooking.getScreeningDate());
        LOGGER.info(Integer.toString(movieBooking.getNumSeats()));

        int bookedSeats = screeningService.getBookedSeats(movieBooking);
        int totalSeats = screeningService.getTotalSeats(movieBooking);

        if ((bookedSeats+movieBooking.getNumSeats())>totalSeats)
            return "error";

        screeningService.bookSeats(movieBooking, bookedSeats+movieBooking.getNumSeats());

        return "result";
    }
}
