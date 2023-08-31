package com.movies.MovieTheatreBookingManager.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "SEAT")
public class Seat {

    @Id
    @SequenceGenerator(
            name = "seat_id_seq",
            sequenceName = "seat_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seat_id_seq"
    )
    @Column(name = "SEAT_ID")
    private long id;
    @Column(name = "ROW_ID")
    private char rowId;
    @Column(name = "ROW_NUMBER")
    private int rowNumber;
    @Column(name = "SCREEN_ID")
    private long screenId;
}
