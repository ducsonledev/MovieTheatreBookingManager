package com.movies.MovieTheatreBookingManager.dto;

public record UserRegistrationRequest (
        String firstname,
        String lastname,
        String email
) {

}
