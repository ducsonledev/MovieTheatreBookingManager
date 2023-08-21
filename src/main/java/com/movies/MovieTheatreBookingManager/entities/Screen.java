package com.movies.MovieTheatreBookingManager.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "SCREEN")
@Data
public class Screen {
    @Id
    @SequenceGenerator(
            name = "screen_id_seq",
            sequenceName = "screen_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "screen_id_seq"
    )
    @Column(name = "SCREEN_ID")
    private long screenId;
    @Column(name = "THEATRE_ID")
    private long theatreId;
    @Column(name = "SEATS_NUM")
    private int seatsNum;
}
