package com.naukma.soccer.services;

import com.naukma.soccer.entities.Match;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface MatchService {
    Page<Match> getFilteredAndPagedMatches(final Specification<Match> matchSpecification, Pageable pageable);

    Match findById(final int id);
}
