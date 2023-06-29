package com.movies.MovieTheatreBookingManager.repositories;

import com.movies.MovieTheatreBookingManager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    // sql query by method name, email as username
    Optional<User> findByEmail (String email);
}
