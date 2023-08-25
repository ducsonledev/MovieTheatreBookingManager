package com.movies.MovieTheatreBookingManager.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "THEATRE")
public class Theatre {

    @Id
    @SequenceGenerator(
            name = "theatre_id_seq",
            sequenceName = "theatre_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "theatre_id_seq"
    )
    @Column(name = "THEATRE_ID")
    private long theatreId;
    @Column(name = "THEATRE_NAME")
    private String theatreName;
    @Column(name = "THEATRE_CITY")
    private String theatreCity;
}
