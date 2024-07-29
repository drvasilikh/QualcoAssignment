package com.example.demo;

import com.example.demo.entities.Country;
import com.example.demo.repositories.CountryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CountryRepositoryTest {

    @Autowired
    private CountryRepository countryRepository;

    @Test
    void testFindAll() {
        List<Country> countries = countryRepository.findAllCountries();
        assertThat(countries).isNotEmpty();
    }
}

