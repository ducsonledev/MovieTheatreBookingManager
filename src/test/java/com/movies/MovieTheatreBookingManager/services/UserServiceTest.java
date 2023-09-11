package com.movies.MovieTheatreBookingManager.services;

import com.movies.MovieTheatreBookingManager.dao.UserDao;
import com.movies.MovieTheatreBookingManager.repositories.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

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
    void getUser() {
        // Given
        int id = 1;

        // When
        underTest.getUser(id);
        // Then
        verify(userDao).selectUserById(id);
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