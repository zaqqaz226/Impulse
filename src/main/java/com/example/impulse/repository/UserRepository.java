package com.example.impulse.repository;

import com.example.impulse.entities.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);
    Optional<User> findByUserName(String name);
}
