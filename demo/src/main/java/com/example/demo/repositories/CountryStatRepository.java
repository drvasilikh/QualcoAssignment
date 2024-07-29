package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.CountryStat;
import com.example.demo.entities.CountryStatId;

public interface CountryStatRepository extends JpaRepository<CountryStat, CountryStatId> {
    
    @Query("SELECT c.name, c.countryCode3, cs.id.year, cs.population, cs.gdp " +
        "FROM CountryStat cs JOIN cs.country c " +
        "WHERE (cs.gdp / cs.population) = (SELECT MAX(cs2.gdp / cs2.population) " +
        "FROM CountryStat cs2 WHERE cs2.country = cs.country)")
    List<Object[]> findMaxGdpPerPopulation();

}
