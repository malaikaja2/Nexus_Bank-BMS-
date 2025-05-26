// dao/UserDAO.java
package com.bankmanagementsystem.dao;


import com.bankmanagementsystem.model.User;
import java.util.List;

public interface UserDao {
    boolean saveUser(User user);
    User getUserByUsername(String username);
    List<User> getAllUsers();
}
