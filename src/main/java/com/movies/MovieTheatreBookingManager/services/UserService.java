package com.movies.MovieTheatreBookingManager.services;

import com.movies.MovieTheatreBookingManager.dao.UserDao;
import com.movies.MovieTheatreBookingManager.dto.UserRegistrationRequest;
import com.movies.MovieTheatreBookingManager.dto.UserUpdateRequest;
import com.movies.MovieTheatreBookingManager.entities.User;
import com.movies.MovieTheatreBookingManager.exception.DuplicateResourceException;
import com.movies.MovieTheatreBookingManager.exception.RequestValidationException;
import com.movies.MovieTheatreBookingManager.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.selectAllUser();
    }
    public User getUser(Integer id) {
        return userDao.selectUserById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User with id [%s] not found".formatted(id)
                ));
    }

    public void addUser(
            UserRegistrationRequest UserRegistrationRequest) {
        String email = UserRegistrationRequest.email();
        if (userDao.existsPersonWithEmail(email)) {
            throw new DuplicateResourceException(
                    "email already exists"
            );
        }
        userDao.insertUser(
                new User(
                        UserRegistrationRequest.firstname(),
                        UserRegistrationRequest.lastname(),
                        UserRegistrationRequest.email()
                )
        );
    }

    public void removeUserById(Integer id) {
        if(!userDao.existsPersonWithId(id))
            throw new ResourceNotFoundException(
                    "User with id [%s] not found".formatted(id)
            );
        userDao.removeUserById(id);
    }

    public void updateUser(
            Integer id,
            UserUpdateRequest updateRequest
    ) {
        var user = getUser(id);

        boolean changes = false;
        if (updateRequest.name() != null && !updateRequest.name().equals(user.getName())) {
            user.setName(updateRequest.name());
            changes = true;
        }

        if (updateRequest.email() != null && !updateRequest.email().equals(user.getEmail())) {
            if (userDao.existsPersonWithEmail(updateRequest.email()))
                throw new DuplicateResourceException("email already taken");
            user.setEmail(updateRequest.email());
            changes = true;
        }

        if (!changes) throw new RequestValidationException("No data changes found");

        userDao.updateUser(user);

    }

}
