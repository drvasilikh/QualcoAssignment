package com.example.demo.services;

import com.example.demo.repositories.CountryStatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilteredStatsService {

    @Autowired
    private CountryStatRepository countryStatRepository;

    public List<Object[]> getFilteredStats(String region, int yearFrom, int yearTo) {
        return countryStatRepository.findFilteredStats(region, yearFrom, yearTo);
    }
}
