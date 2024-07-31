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

    @Query("SELECT c.name, r.name, co.name, cs.id.year, cs.population, cs.gdp " +
           "FROM CountryStat cs " +
           "JOIN cs.country co " +
           "JOIN co.region r " +
           "JOIN r.continent c " +
           "WHERE r.name = :region AND cs.id.year BETWEEN :dateFrom AND :dateTo")
    List<Object[]> findFilteredStats(String region, int dateFrom, int dateTo);
}
