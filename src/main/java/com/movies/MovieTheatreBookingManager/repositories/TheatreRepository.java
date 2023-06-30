package com.movies.MovieTheatreBookingManager.repositories;

import com.movies.MovieTheatreBookingManager.entities.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {

    Theatre findByTheatreId(Long theatreId);
    Theatre findByTheatreNameAndTheatreCity(
            String theatreName, String theatreCity
    );
}
