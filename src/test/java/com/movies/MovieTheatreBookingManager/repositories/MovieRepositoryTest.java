package com.movies.MovieTheatreBookingManager.repositories;

import com.movies.MovieTheatreBookingManager.AbstractTestcontainers;
import com.movies.MovieTheatreBookingManager.entities.Movie;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

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
        // https://www.imdb.com/title/tt0114709/ // Toy Story // Animation
        Movie movie = new Movie();
        String movieName = "Toy Story";
        movie.setMovieName(movieName);
        movie.setMovieTags("Animation");
        Document movieLensPage = null;
        try {
            movieLensPage = Jsoup.connect("https://www.imdb.com/title/tt" + "0114709").get();
        } catch (HttpStatusException e) {
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (movieLensPage != null) {
            Element image = movieLensPage.getElementsByClass("ipc-poster").first().children().first().children().first();
            movie.setMoviePosterUrl(image.attr("src"));
        }
        underTest.save(movie);
        // When
        var actual = underTest.findByMovieName(movieName);
        // Then
        assertThat(actual.getMovieName()).isEqualTo(movieName);
    }

    @Test
    void findByMovieId() {
        // Given

        // When

        // Then
    }
}