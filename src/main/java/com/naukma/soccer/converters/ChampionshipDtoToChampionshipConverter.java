package com.naukma.soccer.converters;

import com.naukma.soccer.dto.ChampionshipDto;
import com.naukma.soccer.entities.Championship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChampionshipDtoToChampionshipConverter implements Converter<ChampionshipDto, Championship> {
    @Autowired
    private CountryDtoToCountryConverter toCountryConverter;

    @Override
    public Championship convert(ChampionshipDto championshipDto) {
        return Championship.builder()
                .id(championshipDto.getId())
                .country(toCountryConverter.convert(championshipDto.getCountry()))
                .name(championshipDto.getName())
                .build();
    }
}
