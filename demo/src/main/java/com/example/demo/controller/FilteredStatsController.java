package com.example.demo.controller;

import com.example.demo.services.FilteredStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/filtered-stats")
public class FilteredStatsController {

    @Autowired
    private FilteredStatsService filteredStatsService;

    @GetMapping
    public List<Object[]> getFilteredStats(
            @RequestParam String region,
            @RequestParam int dateFrom,
            @RequestParam int dateTo) {
        return filteredStatsService.getFilteredStats(region, dateFrom, dateTo);
    }
}
