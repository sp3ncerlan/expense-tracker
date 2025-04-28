package com.spencer.expensetracker.services;

import com.spencer.expensetracker.entities.User;

public interface UserService {

    String authenticateUser(String username, String password);

    User registerUser(User user);

    void deleteUser(Long id);
}
