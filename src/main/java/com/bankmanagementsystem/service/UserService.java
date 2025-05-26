package com.bankmanagementsystem.service;

import com.bankmanagementsystem.dao.UserDao;
import com.bankmanagementsystem.dao.UserDaoImpl;
import com.bankmanagementsystem.model.User;

public class UserService {
    private UserDao userDao = new UserDaoImpl();

    public boolean registerUser(User user) {
        // Check if the username already exists
        if (userDao.getUserByUsername(user.getUsername()) != null) {
            return false; // Username already taken
        }

        // Save the new user
        return userDao.saveUser(user);
    }

    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    public User loginUser(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
