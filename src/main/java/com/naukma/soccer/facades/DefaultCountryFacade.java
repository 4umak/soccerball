package com.naukma.soccer.facades;

import com.naukma.soccer.converters.CountryToCountryDtoConverter;
import com.naukma.soccer.dto.CountryDto;
import com.naukma.soccer.entities.Country;
import com.naukma.soccer.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class DefaultCountryFacade implements CountryFacade {
    @Autowired
    private CountryService countryService;

    @Autowired
    private CountryToCountryDtoConverter countryToCountryDtoConverter;

    @Override
    public CountryDto findById(final int id) {
        return countryToCountryDtoConverter.convert(countryService.getOne(id));
    }

    @Override
    public Page<CountryDto> findAll(Specification<Country> specification, Pageable pageable) {
        return countryService.getAll(specification, pageable).map(countryToCountryDtoConverter::convert);
    }

}
