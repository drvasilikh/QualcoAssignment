package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Continent;

public interface ContinentRepository extends JpaRepository<Continent, Integer> {

}
