package com.movies.MovieTheatreBookingManager.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "THEATRE")
public class Theatre {

    @Id
    @GeneratedValue
    @Column(name = "THEATRE_ID")
    private long theatreId;
    @Column(name = "THEATRE_NAME")
    private String theatreName;
    @Column(name = "THEATRE_CITY")
    private String theatreCity;
}
