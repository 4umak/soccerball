package com.naukma.soccer.controllers;


import com.naukma.soccer.dto.MatchDto;
import com.naukma.soccer.entities.Match;
import com.naukma.soccer.facades.MatchFacade;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.domain.StartingWith;
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
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchFacade matchFacade;

    @GetMapping
    public Page<MatchDto> getFilteredMatches(
            @And({
                    @Spec(path = "championship.name", spec = StartingWith.class),
                    @Spec(path = "t1_name", spec = LikeIgnoreCase.class),
                    @Spec(path = "t2_name", spec = LikeIgnoreCase.class),
            }) final Specification<Match> matchSpecification, final Pageable pageable
    ) {
        return matchFacade.getFilteredAndPagedMatches(matchSpecification, pageable);
    }

    @GetMapping("/{id}")
    public MatchDto findMatchById(@PathVariable
                                  @NotNull final int id) {
        return matchFacade.findById(id);
    }

}
