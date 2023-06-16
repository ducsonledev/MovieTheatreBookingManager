package com.movies.MovieTheatreBookingManager.dao;

import com.movies.MovieTheatreBookingManager.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    List<User> selectAllCustomer();
    Optional<User> selectCustomerById(Integer Id);
    void insertCustomer(User customer);
    boolean existsPersonWithEmail(String email);

    void removeCustomerById(Integer id);

    boolean existsPersonWithId(Integer id);

    void updateCustomer(User updatedCustomer);
}
