package com.movies.MovieTheatreBookingManager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Screen {
    @Id
    @GeneratedValue
    private long screenId;
    private long theatreId;
    private int seatsNum;
}
