package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Country;
import com.example.demo.entities.Language;
import com.example.demo.services.CountryService;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{countryId}/languages")
    public List<Language> getLanguagesByCountryId(@PathVariable int countryId) {
        return countryService.getLanguagesByCountryId(countryId);
    }

    @GetMapping("/max-gdp-per-population")
    public List<Object[]> getMaxGdpPerPopulation() {
        return countryService.getMaxGdpPerPopulation();
    }
}
