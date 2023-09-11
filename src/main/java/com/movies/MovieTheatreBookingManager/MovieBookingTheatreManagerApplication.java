package com.movies.MovieTheatreBookingManager;

import com.github.javafaker.Faker;
import com.movies.MovieTheatreBookingManager.dao.UserDao;
import com.movies.MovieTheatreBookingManager.entities.Role;
import com.movies.MovieTheatreBookingManager.entities.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class MovieBookingTheatreManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieBookingTheatreManagerApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(UserDao userDao) {
		return args -> {
			var faker = new Faker();
			var random = new Random();
			var name = faker.name();
			var password = "abcdefgh";
			String firstName = name.firstName();
			String lastName = name.lastName();
			var user = new User(
					firstName + " " + lastName,
					firstName.toLowerCase() + "." + lastName.toLowerCase()
							+ "@mailservice.com",
					password
			);
			userDao.insertUser(user);
		};
	}
}
