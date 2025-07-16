package com.example.personalfinancemiddleware.repository;

import com.example.personalfinancemiddleware.model.Transaction;
import com.example.personalfinancemiddleware.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserAndDateBetween(User user, LocalDate start, LocalDate end);
    List<Transaction> findByUserAndCategory(User user, String category);
}