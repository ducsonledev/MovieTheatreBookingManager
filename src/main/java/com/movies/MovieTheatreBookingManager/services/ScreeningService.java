package com.movies.MovieTheatreBookingManager.services;

import com.movies.MovieTheatreBookingManager.domain.MovieScreening;
import com.movies.MovieTheatreBookingManager.entities.Movie;
import com.movies.MovieTheatreBookingManager.entities.Screening;
import com.movies.MovieTheatreBookingManager.entities.Theatre;
import com.movies.MovieTheatreBookingManager.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public int getBookedSeats(MovieScreening movieScreening) {
        Screening screening = getScreening(movieScreening);
        return screening.getBookedTickets();
    }

    public int getTotalSeats(MovieScreening movieScreening) {
        Screening screening = getScreening(movieScreening);
        long screenId = screening.getScreenId();
        return screenRepository.findByScreenId(screenId).getSeatsNum();
    }

    public Set<Movie> getMoviesByDate(Date date) {
        Iterable<Screening> screenings = this.screeningRepository
                .findByScreeningDate(new java.sql.Date(date.getTime()));
        Set<Movie> movies = new HashSet<>();

        if(screenings==null) return null;
        for (var screening : screenings)
            if(screening.getScreeningDate() == date)
                movies.add(movieRepository.findByMovieName(screening.getMovieName()));

        return movies;
    }

    public List<Screening> getScreeningsByMovie(String movieName) {
        return screeningRepository.findByMovieName(movieName);
    }

    public  List<MovieScreening> getMovieScreeningsByMovie(String movieName) {
        List<MovieScreening> movieScreenings = new ArrayList<>();
        var screenings = screeningRepository.findByMovieName(movieName);

        if(screenings == null) return null;

        for (var screening : screenings) {
            var movieScreening = new MovieScreening();
            var movie = movieRepository.findByMovieName(movieName);
            var theatreId = screening.getTheatreId();
            var theatre = theatreRepository.findByTheatreId(theatreId);

            movieScreening.setMovieName(movieScreening.getMovieName());
            movieScreening.setMoviePosterURL(movie.getMoviePosterUrl());

            if (theatre != null) {
                movieScreening.setTheatreId(theatreId);
                movieScreening.setTheatreName(theatre.getTheatreName());
                movieScreening.setTheatreCity(theatre.getTheatreCity());
            }

            movieScreening.setScreeningDate(screening.getScreeningDate().toString());
            movieScreening.setScreeningTime(screening.getScreeningTime().toString());

            movieScreening.setNumSeats(
                    screenRepository.findByScreenId(
                            screening.getScreenId()).getSeatsNum()
            );

            movieScreenings.add(movieScreening);
        }


        return movieScreenings;
    }
}
