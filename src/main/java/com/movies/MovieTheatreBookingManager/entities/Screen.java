package com.movies.MovieTheatreBookingManager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Screen {
    @Id
    @GeneratedValue
    private long screenId;
    private long theatreId;
    private int seatsNum;
}
