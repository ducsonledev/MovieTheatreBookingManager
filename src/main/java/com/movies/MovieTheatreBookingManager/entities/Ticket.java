package com.movies.MovieTheatreBookingManager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Ticket {

    @Id
    @GeneratedValue
    private int ticketId;
    private long screeningId;
    private int seatNum;
}
