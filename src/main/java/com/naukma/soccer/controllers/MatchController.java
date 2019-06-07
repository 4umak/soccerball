package com.naukma.soccer.controllers;


import com.naukma.soccer.entities.Match;
import com.naukma.soccer.services.MatchService;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.domain.StartingWith;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping
    public Page<Match> getFilteredMatches(
            @And({
                    @Spec(path = "championship", spec = StartingWith.class),
                    @Spec(path = "t1_name", spec = LikeIgnoreCase.class),
                    @Spec(path = "t2_name", spec = LikeIgnoreCase.class),
                    @Spec(path = "match_date", spec = Equal.class)
            }) final Specification<Match> matchSpecification, final Pageable pageable
    ) {
        return matchService.getFilteredAndPagedMatches(matchSpecification, pageable);
    }

    @GetMapping("/{id}")
    public Match findMatchById(@PathVariable
                               @NotNull final int id) {
        return matchService.findById(id);
    }

}
