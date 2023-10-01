package com.movies.MovieTheatreBookingManager.services;

import com.movies.MovieTheatreBookingManager.dao.MovieDao;
import com.movies.MovieTheatreBookingManager.entities.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieDao movieDao;

    public List<Movie> getAllMovies() {
        return movieDao.selectAllMovie();
    }
}
