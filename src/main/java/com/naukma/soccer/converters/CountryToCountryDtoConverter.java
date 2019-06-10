package com.naukma.soccer.converters;

import com.naukma.soccer.dto.CountryDto;
import com.naukma.soccer.entities.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryToCountryDtoConverter implements Converter<Country, CountryDto> {
    @Override
    public CountryDto convert(Country country) {
        return CountryDto.builder()
                .id(country.getId())
                .name(country.getName())
                .build();
    }
}
