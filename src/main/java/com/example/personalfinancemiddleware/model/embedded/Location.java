package com.example.personalfinancemiddleware.model.embedded;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private Double lat;
    private Double lon;
    private String storeNumber;
}
