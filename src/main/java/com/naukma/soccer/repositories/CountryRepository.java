package com.naukma.soccer.repositories;

import com.naukma.soccer.entities.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    Page<Country> findAll(Specification<Country> specification, Pageable pageable);
}
