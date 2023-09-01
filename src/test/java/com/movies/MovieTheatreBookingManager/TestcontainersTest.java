package com.movies.MovieTheatreBookingManager;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
public class TestcontainersTest {

    @Container
    private static final PostgreSQLContainer<?> postgreSQLContainer =
            new PostgreSQLContainer<>("postgres:latest")
                    .withDatabaseName("sonscode-dao-unit-test")
                    .withUsername("sonscode")
                    .withPassword("password");

    @Test
    void canStartPostgresDB() {
       assertThat(postgreSQLContainer.isRunning()).isTrue();
       assertThat(postgreSQLContainer.isCreated()).isTrue();
       // assertThat(postgreSQLContainer.isHealthy()).isTrue();
    }

    @Test
    void canApplyDBMigrationsWithFlyway() {
        Flyway flyway = Flyway.configure().dataSource(
                postgreSQLContainer.getJdbcUrl(),
                postgreSQLContainer.getUsername(),
                postgreSQLContainer.getPassword()
        ).load();
        flyway.migrate();
        System.out.println();
    }
}
