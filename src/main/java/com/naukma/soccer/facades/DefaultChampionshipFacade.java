package com.naukma.soccer.facades;

import com.naukma.soccer.converters.ChampionshipToChampionshipDtoConverter;
import com.naukma.soccer.dto.ChampionshipDto;
import com.naukma.soccer.entities.Championship;
import com.naukma.soccer.services.ChampionshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class DefaultChampionshipFacade implements ChampionshipFacade {
    @Autowired
    private ChampionshipService championshipService;

    @Autowired
    private ChampionshipToChampionshipDtoConverter converter;

    @Override
    public Page<ChampionshipDto> getAll(final Specification<Championship> specification, final Pageable pageable) {
        return championshipService.getAll(specification, pageable).map(converter::convert);
    }

    @Override
    public ChampionshipDto getOne(final int id) {
        return converter.convert(championshipService.getOne(id));
    }
}
