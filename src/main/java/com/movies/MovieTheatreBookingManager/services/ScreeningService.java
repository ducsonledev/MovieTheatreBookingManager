package com.movies.MovieTheatreBookingManager.services;

import com.movies.MovieTheatreBookingManager.domain.MovieScreening;
import com.movies.MovieTheatreBookingManager.entities.Movie;
import com.movies.MovieTheatreBookingManager.entities.Screening;
import com.movies.MovieTheatreBookingManager.entities.Theatre;
import com.movies.MovieTheatreBookingManager.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;

@Service
@AllArgsConstructor
public class ScreeningService {

    private ScreeningRepository screeningRepository;
    private MovieRepository movieRepository;
    private TheatreRepository theatreRepository;
    private TicketRepository ticketRepository;
    private ScreenRepository screenRepository;

    private Screening getScreening(MovieScreening movieScreening) {
        Theatre theatre = theatreRepository.findByTheatreNameAndTheatreCity(
                movieScreening.getTheatreName(),
                movieScreening.getTheatreCity()
        );
        if(theatre == null) return null;
        return screeningRepository.findByMovieNameAndTheatreIdAndScreeningDateAndScreeningTime(
                movieScreening.getMovieName(),
                theatre.getTheatreId(),
                java.sql.Date.valueOf(movieScreening.getScreeningDate()),
                java.sql.Time.valueOf(movieScreening.getScreeningTime())
        );
    }

    public int bookSeats(MovieScreening movieScreening, int seats) {
      Screening screening = getScreening(movieScreening);
      screening.setBookedTickets(seats);
      screeningRepository.save(screening);
      return getBookedSeats(movieScreening);
    }

    private int getBookedSeats(MovieScreening movieScreening) {
        Screening screening = getScreening(movieScreening);
        return screening.getBookedTickets();
    }

    public int getTotalSeats(MovieScreening movieScreening) {
        Screening screening = getScreening(movieScreening);
        long screenId = screening.getScreenId();
        return screenRepository.findByScreenId(screenId).getSeatsNum();
    }

    public Set<Movie> getMoviesByDate(Date date) {
        // todo: duplicate movies or not?
        return null;
    }
}
