package com.example.demo;

import com.example.demo.controller.CountryController;
import com.example.demo.entities.Country;
import com.example.demo.entities.Language;
import com.example.demo.services.CountryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class CountryControllerTest {

    @Mock
    private CountryService countryService;

    @InjectMocks
    private CountryController countryController;

    private MockMvc mockMvc;

    @Test
    void testGetAllCountries() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(countryController).build();

        Country country1 = new Country(1, "Country A", BigDecimal.valueOf(12345.67), new Date(), "CA", "CYA", null);
        Country country2 = new Country(2, "Country B", BigDecimal.valueOf(98765.43), new Date(), "CB", "CYB", null);

        List<Country> countries = Arrays.asList(country1, country2);

        when(countryService.getAllCountries()).thenReturn(countries);

        mockMvc.perform(get("/countries")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value("Country A"))
                .andExpect(jsonPath("$[1].name").value("Country B"));
    }

    @Test
    void testGetLanguagesByCountryId() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(countryController).build();

        Language language1 = new Language(1, "English");
        Language language2 = new Language(2, "French");

        List<Language> languages = Arrays.asList(language1, language2);

        when(countryService.getLanguagesByCountryId(1)).thenReturn(languages);

        mockMvc.perform(get("/countries/1/languages")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].language").value("English"))
                .andExpect(jsonPath("$[1].language").value("French"));
    }

    @Test
    void testGetMaxGdpPerPopulation() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(countryController).build();

        Object[] stat1 = new Object[]{"Country A", "CYA", 2020, 500000, BigDecimal.valueOf(25000000)};
        Object[] stat2 = new Object[]{"Country B", "CYB", 2019, 1000000, BigDecimal.valueOf(60000000)};

        List<Object[]> stats = Arrays.asList(stat1, stat2);

        when(countryService.getMaxGdpPerPopulation()).thenReturn(stats);

        mockMvc.perform(get("/countries/max-gdp-per-population")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0][0]").value("Country A"))
                .andExpect(jsonPath("$[0][1]").value("CYA"))
                .andExpect(jsonPath("$[0][2]").value(2020))
                .andExpect(jsonPath("$[0][3]").value(500000))
                .andExpect(jsonPath("$[0][4]").value(25000000))
                .andExpect(jsonPath("$[1][0]").value("Country B"))
                .andExpect(jsonPath("$[1][1]").value("CYB"))
                .andExpect(jsonPath("$[1][2]").value(2019))
                .andExpect(jsonPath("$[1][3]").value(1000000))
                .andExpect(jsonPath("$[1][4]").value(60000000));
    }
}