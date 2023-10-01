package com.movies.MovieTheatreBookingManager;

import com.github.javafaker.Faker;
import com.movies.MovieTheatreBookingManager.entities.Role;
import com.movies.MovieTheatreBookingManager.entities.User;
import com.movies.MovieTheatreBookingManager.repositories.MovieRepository;
import com.movies.MovieTheatreBookingManager.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class MovieBookingTheatreManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieBookingTheatreManagerApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(UserRepository userRepository) {
		return args -> {
			var faker = new Faker();
			var random = new Random();
			var name = faker.name();
			var password = "abcdefgh";
			Role role = Role.CUSTOMER;
			String username = name.username();
			var user = new User(
					username,
					username.toLowerCase() + "@mailservice.com",
					password
			);
			userRepository.save(user);
		};
	}
}
