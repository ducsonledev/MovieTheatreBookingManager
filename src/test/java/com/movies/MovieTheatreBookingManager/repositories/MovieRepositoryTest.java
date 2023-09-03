package com.movies.MovieTheatreBookingManager.repositories;

import com.movies.MovieTheatreBookingManager.AbstractTestcontainers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MovieRepositoryTest extends AbstractTestcontainers {

    @Autowired
    private MovieRepository underTest;
    @BeforeEach
    void setUp() {
    }

    @Test
    void findByMovieName() {
        // Given

        // When

        // Then
    }

    @Test
    void findByMovieId() {
        // Given

        // When

        // Then
    }
}