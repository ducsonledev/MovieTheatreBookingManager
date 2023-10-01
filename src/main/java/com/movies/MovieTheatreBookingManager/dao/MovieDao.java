package com.movies.MovieTheatreBookingManager.dao;

import com.movies.MovieTheatreBookingManager.entities.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieDao {


    List<Movie> selectAllMovie();
    Optional<Movie> selectMovieById(Integer Id);
    void insertMovie(Movie movie);
    void removeMovieById(Integer id);
    boolean existsMovieWithName(String movieName);

    boolean existsMovieWithId(Integer id);

    void updateMovie(Movie updatedMovie);
}
