package com.edulearn.service;

import com.edulearn.model.User;
import com.edulearn.dao.UserDAO;
import java.sql.SQLException;

public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User authenticate(String email, String password) throws SQLException {
        User user = userDAO.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public User register(String name, String email, String password) throws SQLException {
        User existingUser = userDAO.findByEmail(email);
        if (existingUser != null) {
            throw new IllegalArgumentException("Email already exists");
        }

        User newUser = new User(null, name, email, password, "STUDENT");
        return userDAO.create(newUser);
    }
}