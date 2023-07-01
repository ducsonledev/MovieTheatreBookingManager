package com.movies.MovieTheatreBookingManager.dao;

import com.movies.MovieTheatreBookingManager.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    List<User> selectAllUser();
    Optional<User> selectUserById(Integer Id);
    void insertUser(User User);
    boolean existsPersonWithEmail(String email);

    void removeUserById(Integer id);

    boolean existsPersonWithId(Integer id);

    void updateUser(User updatedUser);
}
