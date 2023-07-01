package com.movies.MovieTheatreBookingManager.dao;

import com.movies.MovieTheatreBookingManager.entities.User;
import com.movies.MovieTheatreBookingManager.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

    private final UserRepository userRepository;
    @Override
    public List<User> selectAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> selectUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void insertUser(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean existsPersonWithEmail(String email) {
        return userRepository.findByEmail(email) != null;
    }

    @Override
    public void removeUserById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean existsPersonWithId(Integer id) {
        return userRepository.findById(id) != null;
    }

    @Override
    public void updateUser(User updatedUser) {
        userRepository.save(updatedUser);
    }
}
