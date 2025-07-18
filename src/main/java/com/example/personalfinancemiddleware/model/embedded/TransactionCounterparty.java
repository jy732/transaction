package com.example.personalfinancemiddleware.model.embedded;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionCounterparty {
    private String name;
    private String entityId;
    private String type;
    private String website;
    private String logoUrl;
    private String confidenceLevel;
}
