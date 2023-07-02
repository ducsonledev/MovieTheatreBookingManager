package com.movies.MovieTheatreBookingManager.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "SCREEN")
@Data
public class Screen {
    @Id
    @GeneratedValue
    @Column(name = "SCREEN_ID")
    private long screenId;
    @Column(name = "THEATRE_ID")
    private long theatreId;
    @Column(name = "SEATS_NUM")
    private int seatsNum;
}
