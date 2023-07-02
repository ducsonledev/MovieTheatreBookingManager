package com.movies.MovieTheatreBookingManager.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TICKET")
@Data
public class Ticket {

    @Id
    @GeneratedValue
    @Column(name = "TICKET_ID")
    private int ticketId;
    @Column(name = "SCREENING_ID")
    private long screeningId;
    @Column(name = "SEAT_NUM")
    private int seatNum;
}
