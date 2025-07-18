package com.example.personalfinancemiddleware.model.embedded;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentMeta {
    private String referenceNumber;
    private String ppdId;
    private String payee;
    private String byOrderOf;
    private String payer;
    private String paymentMethod;
    private String paymentProcessor;
    private String reason;
}
