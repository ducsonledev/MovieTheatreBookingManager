package com.movies.MovieTheatreBookingManager.dto;

public record UserUpdateRequest (
    String username,
    String email
) {
}
