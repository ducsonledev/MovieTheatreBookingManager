package com.movies.MovieTheatreBookingManager.repositories;

import com.movies.MovieTheatreBookingManager.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findByMovieName(String movieName);
    Movie findByMovieId(long movieId);
    boolean existsMovieByMovieName(String movieName);
    boolean existsMovieByMovieId(Long id);
}
