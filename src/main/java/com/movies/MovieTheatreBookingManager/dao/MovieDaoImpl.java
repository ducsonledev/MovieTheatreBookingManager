package com.movies.MovieTheatreBookingManager.dao;

import com.movies.MovieTheatreBookingManager.dao.MovieDao;
import com.movies.MovieTheatreBookingManager.entities.Movie;

import java.util.List;
import java.util.Optional;

public class MovieDaoImpl implements MovieDao {


    @Override
    public List<Movie> selectAllMovie() {
        return null;
    }

    @Override
    public Optional<Movie> selectCustomerById(Integer Id) {
        return Optional.empty();
    }

    @Override
    public void insertMovie(Movie movie) {

    }

    @Override
    public void removeMovieById(Integer id) {

    }

    @Override
    public boolean existsMovieWithName(String movieName) {
        return false;
    }

    @Override
    public boolean existsMovieWithId(Integer id) {
        return false;
    }

    @Override
    public void updateMovie(Movie updatedMovie) {

    }
}
