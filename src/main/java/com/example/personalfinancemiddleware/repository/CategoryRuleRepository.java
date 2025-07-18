package com.example.personalfinancemiddleware.repository;

import com.example.personalfinancemiddleware.model.CategoryRule;
import com.example.personalfinancemiddleware.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRuleRepository extends JpaRepository<CategoryRule, Long> {
    List<CategoryRule> findByUserOrderByPriorityAsc(User user);
}
