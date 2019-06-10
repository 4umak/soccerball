package com.naukma.soccer.services;

import com.naukma.soccer.entities.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface CountryService {
    Page<Country> getAll(Specification<Country> specification, Pageable pageable);

    Country getOne(final int id);
}
