package com.movies.MovieTheatreBookingManager.repositories;

import com.movies.MovieTheatreBookingManager.entities.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Long> {

    List<Screening> findByScreeningDate(Date screeningDate);
    List<Screening> findByMovieName(String movieName);
    Screening findByMovieNameAndTheatreIdAndScreeningDateAndScreeningTime(
            String movieName,
            long theatreId,
            Date screeningDate,
            Time screeningTime
    );
}
