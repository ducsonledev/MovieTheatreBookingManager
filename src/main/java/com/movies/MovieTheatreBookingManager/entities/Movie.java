package com.movies.MovieTheatreBookingManager.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MOVIE")
@Data
public class Movie {

    @Id
    @SequenceGenerator(
            name = "movie_movie_id_seq",
            sequenceName = "movie_movie_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movie_movie_id_seq"
    )
    @Column(name = "MOVIE_ID")
    private long movieId;
    @Column(name = "MOVIE_NAME")
    private String movieName;
    @Column(name = "MOVIE_TAGS")
    private String movieTags;
    @Column(name = "MOVIE_POSTER_URL")
    private String moviePosterUrl;
}
