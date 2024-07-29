package com.example.demo.entities;

import java.math.BigDecimal;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "country_stats")
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

        // Getter for year
        public int getYear() {
            return id.getYear();
        }
}
