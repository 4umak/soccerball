package com.naukma.soccer.converters;

import com.naukma.soccer.dto.CountryDto;
import com.naukma.soccer.entities.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryDtoToCountryConverter implements Converter<CountryDto, Country> {
    @Override
    public Country convert(CountryDto countryDto) {
        return Country.builder()
                .id(countryDto.getId())
                .name(countryDto.getName())
                .build();
    }
}
