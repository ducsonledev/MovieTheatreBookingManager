package com.movies.MovieTheatreBookingManager.controller;

import com.movies.MovieTheatreBookingManager.entities.Movie;
import com.movies.MovieTheatreBookingManager.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    //@Autowired
    //private

    @GetMapping
    public List<Movie> getMovies() {

        return null;
    }

}
