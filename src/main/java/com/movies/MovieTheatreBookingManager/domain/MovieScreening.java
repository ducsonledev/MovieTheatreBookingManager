package com.movies.MovieTheatreBookingManager.domain;

import lombok.Data;

@Data
public class MovieScreening {

    private String movieName;
    private String moviePosterURL;
    private long theatreId;
    private String theatreName;
    private String theatreCity;
    private String screeningDate;
    private String screeningTime;
    private int numSeats;
}
