package com.movies.MovieTheatreBookingManager.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MOVIE")
@Data
public class Movie {

    @Id
    @GeneratedValue
    @Column(name = "MOVIE_ID")
    private int movieId;
    @Column(name = "MOVIE_NAME")
    private String movieName;
    @Column(name = "MOVIE_TAGS")
    private String movieTags;
    @Column(name = "MOVIE_POSTER_URL")
    private String moviePosterUrl;
}
