package com.example.personalfinancemiddleware.repository;

import com.example.personalfinancemiddleware.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
