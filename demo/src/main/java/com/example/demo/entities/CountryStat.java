package com.example.demo.entities;

import java.math.BigDecimal;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryStat {
    @EmbeddedId
    private CountryStatId id;

    @ManyToOne
    @MapsId("countryId")
    @JoinColumn(name = "country_id")
    private Country country;

    private Integer population;
    private BigDecimal gdp;
}
