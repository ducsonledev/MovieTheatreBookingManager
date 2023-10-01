package com.movies.MovieTheatreBookingManager.controller;

import com.movies.MovieTheatreBookingManager.dao.MovieDao;
import com.movies.MovieTheatreBookingManager.entities.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieDao movieDao;

    @GetMapping
    public List<Movie> getMovies() {
        return movieDao.selectAllMovie();
    }

}
