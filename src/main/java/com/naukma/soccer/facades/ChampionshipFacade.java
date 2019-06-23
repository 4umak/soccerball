package com.naukma.soccer.facades;

import com.naukma.soccer.dto.ChampionshipDto;
import com.naukma.soccer.entities.Championship;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface ChampionshipFacade {
    Page<ChampionshipDto> getAll(Specification<Championship> specification, Pageable pageable);

    ChampionshipDto getOne(int id);
}
