package com.naukma.soccer.services;

import com.naukma.soccer.entities.Country;
import com.naukma.soccer.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class DefaultCountryService implements CountryService {

    @Autowired
    private CountryRepository countryRepository;


    public Page<Country> getAll(Specification<Country> specification, Pageable pageable) {
        return countryRepository.findAll(specification, pageable);
    }

    public Country getOne(final int id) {
        return countryRepository.getOne(id);
    }
}
