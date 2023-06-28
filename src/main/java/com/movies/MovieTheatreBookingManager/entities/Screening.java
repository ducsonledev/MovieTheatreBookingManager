package com.movies.MovieTheatreBookingManager.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Screening implements Cloneable {

    @Id
    @GeneratedValue
    private long screeningId;
    private long theatreId;
    private long screenId;
    private String movieName;
    private java.sql.Date screeningDate;
    private java.sql.Time screeningTime;
    private int bookedTickets;

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
