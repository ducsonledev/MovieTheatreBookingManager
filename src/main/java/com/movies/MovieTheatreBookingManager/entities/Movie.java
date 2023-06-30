package com.movies.MovieTheatreBookingManager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Movie {

    @Id
    @GeneratedValue
    private Integer movieId;
    private String movieName;
    private String movieTags;
    private String moviePosterUrl;
}
