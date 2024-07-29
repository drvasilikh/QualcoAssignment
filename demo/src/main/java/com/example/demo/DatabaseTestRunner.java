package com.example.demo;

import com.example.demo.entities.Country;
import com.example.demo.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseTestRunner implements CommandLineRunner {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Testing database connection...");

        List<Country> countries = countryRepository.findAll();
        if (countries.isEmpty()) {
            System.out.println("No countries found.");
        } else {
            System.out.println("Countries found: " + countries.size());
            countries.forEach(country -> System.out.println(country.getName()));
        }
    }
}
