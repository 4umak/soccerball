package com.naukma.soccer.controllers;

import com.naukma.soccer.dto.ChampionshipDto;
import com.naukma.soccer.entities.Championship;
import com.naukma.soccer.facades.ChampionshipFacade;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/championships")
public class ChampionshipController {
    @Autowired
    private ChampionshipFacade championshipFacade;

    @GetMapping
    public Page<ChampionshipDto> getAll(
            @And({
                    @Spec(path = "name", spec = LikeIgnoreCase.class)
            }) final Specification<Championship> specification,
            final Pageable pageable) {
        return championshipFacade.getAll(specification, pageable);
    }

    @GetMapping("/{id}")
    public ChampionshipDto getOne(@PathVariable final int id) {
        return championshipFacade.getOne(id);
    }
}
