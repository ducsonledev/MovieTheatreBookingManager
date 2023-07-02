package com.movies.MovieTheatreBookingManager.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "SEAT")
public class Seat {

    @Id
    @GeneratedValue
    @Column(name = "SEAT_ID")
    private int id;
    @Column(name = "ROW_ID")
    private char rowId;
    @Column(name = "ROW_NUMBER")
    private int rowNumber;
    @Column(name = "SCREEN_ID")
    private int screenId;
}
