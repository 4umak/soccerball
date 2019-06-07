package com.naukma.soccer.services;

import com.naukma.soccer.entities.Match;
import com.naukma.soccer.exceptions.NoSuchEntityException;
import com.naukma.soccer.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public Page<Match> getFilteredAndPagedMatches(final Specification<Match> matchSpecification, Pageable pageable) {
        return matchRepository.findAll(matchSpecification, pageable);
    }

    public Match findById(final int id) {
        Optional<Match> foundMatch = matchRepository.findById(id);
        return foundMatch.orElseThrow(() -> new NoSuchEntityException(String
                .format("The match with id %s was not found", id)));
    }
}
