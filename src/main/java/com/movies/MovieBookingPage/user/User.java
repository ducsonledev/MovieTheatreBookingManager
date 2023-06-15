package com.movies.MovieBookingPage.user;


import jakarta.persistence.Entity;

@Entity
public class User {

    private int id;
    private String username;
    private String email;

    private String password;
}
