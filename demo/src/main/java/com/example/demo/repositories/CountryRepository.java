package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Query("SELECT c FROM Country c ORDER BY c.name")
    List<Country> findAllCountries();
}
