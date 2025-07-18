package com.example.personalfinancemiddleware.model;

import com.plaid.client.model.Transaction.PaymentChannelEnum;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import lombok.*;

@Entity
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

    @Column(nullable = false)
    private String transactionId; // Plaid's unique transaction ID

    @Column(nullable = false)
    private String accountId;

    private LocalDate date;
    private Double amount;

    private String name;
    private String merchantName;

    private String category; // Your assigned category

    private Boolean pending;

    private List<String> plaidCategory; // Raw Plaid category (string, comma-separated)

    // Optional, but handy:
    private String originalDescription;
    private PaymentChannelEnum paymentChannel;
    private String logoUrl;
    private String website;

    // System fields
    private Boolean isManuallyCategorized;
    private Boolean alertSent;

    // Optionally store rawData for debugging/audit (can drop for prod if not needed)
    @Column(columnDefinition = "text")
    private String rawData;
}
