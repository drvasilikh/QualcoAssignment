package com.example.demo.entities;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int countryId;
    private String name;
    private BigDecimal area;
    private Date nationalDay;
    private String countryCode2;
    private String countryCode3;

    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;
}