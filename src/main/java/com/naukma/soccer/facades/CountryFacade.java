package com.naukma.soccer.facades;

import com.naukma.soccer.dto.CountryDto;
import com.naukma.soccer.entities.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface CountryFacade {
    CountryDto findById(int id);

    Page<CountryDto> findAll(Specification<Country> specification, Pageable pageable);
}
