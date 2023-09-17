package com.movies.MovieTheatreBookingManager.journey;

import com.github.javafaker.Faker;
import com.movies.MovieTheatreBookingManager.dto.UserRegistrationRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT) // will not start a server
public class UserIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void canRegisterAUser() {
        Faker faker = new Faker();
        String username = faker.name().username();
        String email = username + UUID.randomUUID() + "@mailservice.com";
        String password = "password";
        // create registration request
        var userRegistrationRequest = new UserRegistrationRequest(username, email, password);
        // send a post request
        webTestClient.post()
                .uri("/api/v1/auth")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(userRegistrationRequest), UserRegistrationRequest.class)
                .exchange() // how we send the request
                .expectStatus()
                .isOk();
        // get all users
        // make sure that user is present
        // get user by id
    }
}
