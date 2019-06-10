package com.naukma.soccer.facades;

import com.naukma.soccer.dto.MatchDto;
import com.naukma.soccer.entities.Match;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface MatchFacade {
    Page<MatchDto> getFilteredAndPagedMatches(Specification<Match> specification, Pageable pageable);
    MatchDto findById(int id);
}
