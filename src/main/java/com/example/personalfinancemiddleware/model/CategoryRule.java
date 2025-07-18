package com.example.personalfinancemiddleware.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "category_rules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String matchPattern; // Substring or regex to match merchant/description

    @Column(nullable = false)
    private String assignedCategory;

    @Column(nullable = false)
    private Integer priority; // Lower = higher priority
}
