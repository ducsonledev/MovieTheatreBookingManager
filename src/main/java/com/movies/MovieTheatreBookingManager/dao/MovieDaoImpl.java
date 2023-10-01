package com.movies.MovieTheatreBookingManager.dao;

import com.movies.MovieTheatreBookingManager.entities.Movie;
import com.movies.MovieTheatreBookingManager.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class MovieDaoImpl implements MovieDao {

    private final MovieRepository movieRepository;

    @Override
    public List<Movie> selectAllMovie() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> selectMovieById(Integer id) {
        return movieRepository.findById(id);
    }

    @Override
    public void insertMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void removeMovieById(Integer id) {
        movieRepository.deleteById(id);
    }

    @Override
    public boolean existsMovieWithName(String movieName) {
        return movieRepository.existsMovieByMovieName(movieName);
    }

    @Override
    public boolean existsMovieWithId(Integer id) {
        return existsMovieWithId(id);
    }

    @Override
    public void updateMovie(Movie updatedMovie) {
        movieRepository.save(updatedMovie);
    }
}
