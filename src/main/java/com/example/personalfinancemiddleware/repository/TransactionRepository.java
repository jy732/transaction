package com.example.personalfinancemiddleware.repository;

import com.example.personalfinancemiddleware.model.Transaction;
import com.example.personalfinancemiddleware.model.User;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserAndDateBetween(User user, LocalDate start, LocalDate end);

    List<Transaction> findByUserAndCategory(User user, String category);
}
