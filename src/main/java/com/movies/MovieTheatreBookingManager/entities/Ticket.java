package com.movies.MovieTheatreBookingManager.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TICKET")
@Data
public class Ticket {

    @Id
    @SequenceGenerator(
            name = "ticket_ticket_id_seq",
            sequenceName = "ticket_ticket_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ticket_ticket_id_seq"
    )
    @Column(name = "TICKET_ID")
    private long ticketId;
    @Column(name = "SCREENING_ID")
    private long screeningId;
    @Column(name = "SEAT_NUM")
    private int seatNum;
}
