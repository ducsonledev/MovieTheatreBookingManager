package com.movies.MovieTheatreBookingManager.dto;

public record UserRegistrationRequest (
        String username,
        String email,
        String password
) {

}
