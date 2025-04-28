package com.spencer.expensetracker.services.impl;

import com.spencer.expensetracker.entities.User;
import com.spencer.expensetracker.repositories.UserRepository;
import com.spencer.expensetracker.services.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String authenticateUser(String username, String password) {
        User user = userRepository.findUserByUsername(username);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid credentials");
        }

        return "Authentication successful for user: " + username;
    }

    @Override
    public User registerUser(User user) {
        if (userRepository.findUserByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username already exists");
        }

        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteUserById(id);
    }
}
