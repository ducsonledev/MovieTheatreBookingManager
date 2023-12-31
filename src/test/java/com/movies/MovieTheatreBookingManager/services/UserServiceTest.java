package com.movies.MovieTheatreBookingManager.services;

import com.movies.MovieTheatreBookingManager.AbstractTestcontainers;
import com.movies.MovieTheatreBookingManager.dao.UserDao;
import com.movies.MovieTheatreBookingManager.entities.Role;
import com.movies.MovieTheatreBookingManager.entities.User;
import com.movies.MovieTheatreBookingManager.exception.ResourceNotFoundException;
import com.movies.MovieTheatreBookingManager.repositories.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class UserServiceTest {

    private UserService underTest;
    private AutoCloseable autoCloseable;
    @Mock private UserDao userDao;
    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new UserService(userDao);
    }

    @AfterEach
    void tearDown()throws Exception {
        autoCloseable.close();
    }

    @Test
    void getAllUsers() {
        // When
        underTest.getAllUsers();
        // Then
        verify(userDao)
                .selectAllUser();
    }

    @Test
    void canGetUser() {
        // Given
        int id = 9;
        var user = new User(
                id, "Johnny", "john@mailservice.com", "abcdefgh", Role.CUSTOMER
        );
        // telling mock what to do when it invokes selectUserById
        // returns optional
        when(userDao.selectUserById(id)).thenReturn(Optional.of(user));
        // When
        var actual = underTest.getUser(id);
        // Then
        assertThat(actual).isEqualTo(user);
    }
    @Test
    void willThrowThenGetUserReturnsEmptyOptional() {
        // Given
        int id = 9;
        // telling mock what to do when it invokes selectUserById
        // returns optional
        when(userDao.selectUserById(id)).thenReturn(Optional.empty());
        // When
        // Then
        assertThatThrownBy(() -> underTest.getUser(id))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(
                        "User with id [%s] not found".formatted(id));

    }

    @Test
    void addUser() {
        // Given

        // When

        // Then
    }

    @Test
    void removeUserById() {
        // Given

        // When

        // Then
    }

    @Test
    void updateUser() {
        // Given

        // When

        // Then
    }
}