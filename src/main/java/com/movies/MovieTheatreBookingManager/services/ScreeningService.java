package com.movies.MovieTheatreBookingManager.services;

import com.movies.MovieTheatreBookingManager.domain.MovieScreening;
import com.movies.MovieTheatreBookingManager.entities.Movie;
import com.movies.MovieTheatreBookingManager.entities.Screening;

import java.util.*;

public interface ScreeningService {
    int bookSeats(MovieScreening movieScreening, int seats);

    int getBookedSeats(MovieScreening movieScreening);

    int getTotalSeats(MovieScreening movieScreening);

    Set<Movie> getMoviesByDate(Date date);

    List<Screening> getScreeningsByMovie(String movieName);

    List<MovieScreening> getMovieScreeningsByMovie(String movieName);

}
