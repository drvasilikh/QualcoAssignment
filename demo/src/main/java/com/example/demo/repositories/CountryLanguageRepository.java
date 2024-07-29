package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.CountryLanguage;
import com.example.demo.entities.CountryLanguageId;

public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguageId> {
    @Query("SELECT cl FROM CountryLanguage cl WHERE cl.country.countryId = :countryId")
    List<CountryLanguage> findByCountryId(@Param("countryId") int countryId);
}
