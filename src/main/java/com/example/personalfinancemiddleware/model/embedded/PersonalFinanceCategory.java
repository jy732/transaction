package com.example.personalfinancemiddleware.model.embedded;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonalFinanceCategory {
    private String primary;
    private String detailed;
    private String confidenceLevel;
}
