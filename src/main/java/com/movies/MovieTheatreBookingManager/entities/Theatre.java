package com.movies.MovieTheatreBookingManager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Theatre {

    @Id
    @GeneratedValue
    private long theatreId;
    private String theatreName;
    private String theatreCity;
}
