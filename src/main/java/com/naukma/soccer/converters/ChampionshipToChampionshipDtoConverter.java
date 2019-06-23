package com.naukma.soccer.converters;

import com.naukma.soccer.dto.ChampionshipDto;
import com.naukma.soccer.entities.Championship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChampionshipToChampionshipDtoConverter implements Converter<Championship, ChampionshipDto> {
    @Autowired
    private CountryToCountryDtoConverter toCountryDtoConverter;

    @Override
    public ChampionshipDto convert(final Championship championship) {
        return ChampionshipDto.builder()
                .country(toCountryDtoConverter.convert(championship.getCountry()))
                .id(championship.getId())
                .name(championship.getName())
                .build();
    }
}
