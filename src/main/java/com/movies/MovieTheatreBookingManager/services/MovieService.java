package com.movies.MovieTheatreBookingManager.services;

import com.movies.MovieTheatreBookingManager.dao.MovieDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieDao movieDao;
}
