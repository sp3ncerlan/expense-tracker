package com.spencer.expensetracker.repositories;

import com.spencer.expensetracker.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);

    void deleteUserById(Long id);
}
