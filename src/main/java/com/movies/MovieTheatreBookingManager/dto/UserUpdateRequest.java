package com.movies.MovieTheatreBookingManager.dto;

public record UserUpdateRequest (
    String firstname,
    String lastname,
    String email
) {
}
