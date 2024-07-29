package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Country;
import com.example.demo.entities.CountryLanguage;
import com.example.demo.entities.Language;
import com.example.demo.repositories.CountryLanguageRepository;
import com.example.demo.repositories.CountryRepository;
import com.example.demo.repositories.CountryStatRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private CountryLanguageRepository countryLanguageRepository;
    @Autowired
    private CountryStatRepository countryStatRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAllCountries();
    }

    public List<Language> getLanguagesByCountryId(int countryId) {
        return countryLanguageRepository.findByCountryId(countryId).stream()
            .map(CountryLanguage::getLanguage)
            .collect(Collectors.toList());
    }

    public List<Object[]> getMaxGdpPerPopulation() {
        return countryStatRepository.findMaxGdpPerPopulation();
    }
}
