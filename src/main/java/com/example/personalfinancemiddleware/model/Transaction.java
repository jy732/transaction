package com.example.personalfinancemiddleware.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.*;

@Entity
@Table(name = "user_transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LocalDate date;

    private Double amount;

    private String merchant;

    private String description;

    private String category;

    private boolean isManuallyCategorized;

    private boolean alertSent;

    @Column(columnDefinition = "TEXT")
    private String rawData; // JSON string of the Plaid/raw transaction if needed
}
