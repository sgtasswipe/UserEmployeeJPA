package com.example.useremployee.repositories;

import com.example.useremployee.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    List<User> findAllByEmail(String email);
}
