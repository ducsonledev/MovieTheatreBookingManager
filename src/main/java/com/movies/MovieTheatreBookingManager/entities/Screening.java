package com.movies.MovieTheatreBookingManager.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "SCREENING")
@Data
public class Screening implements Cloneable {

    @Id
    @SequenceGenerator(
            name = "screening_screening_id_seq",
            sequenceName = "screening_screening_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "screening_screening_id_seq"
    )
    @Column(name = "SCREENING_ID")
    private long screeningId;
    @Column(name = "THEATRE_ID")
    private long theatreId;
    @Column(name = "SCREEN_ID")
    private long screenId;
    @Column(name = "MOVIE_NAME")
    private String movieName;
    @Column(name = "SCREENING_DATE")
    private java.sql.Date screeningDate;
    @Column(name = "SCREENING_TIME")
    private java.sql.Time screeningTime;
    @Column(name = "BOOKED_TICKETS")
    private int bookedTickets;

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
