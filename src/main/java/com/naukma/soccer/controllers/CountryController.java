package com.naukma.soccer.controllers;

import com.naukma.soccer.dto.CountryDto;
import com.naukma.soccer.entities.Country;
import com.naukma.soccer.facades.CountryFacade;
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

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryFacade countryFacade;

    @GetMapping
    public Page<CountryDto> getAll(
            @And({
                    @Spec(path = "name", spec = LikeIgnoreCase.class)
            }) final Specification<Country> countryFilter,
            final Pageable pageable
    ) {
        return countryFacade.findAll(countryFilter, pageable);
    }

    @GetMapping("/{id}")
    public CountryDto getOne(@PathVariable
                             @NotNull final int id) {
        return countryFacade.findById(id);
    }

}
