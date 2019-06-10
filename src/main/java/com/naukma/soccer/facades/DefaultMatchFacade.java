package com.naukma.soccer.facades;

import com.naukma.soccer.converters.MatchToMatchDtoConverter;
import com.naukma.soccer.dto.MatchDto;
import com.naukma.soccer.entities.Match;
import com.naukma.soccer.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class DefaultMatchFacade implements MatchFacade {

    @Autowired
    private MatchToMatchDtoConverter matchToMatchDtoConverter;

    @Autowired
    private MatchService matchService;

    @Override
    public Page<MatchDto> getFilteredAndPagedMatches(Specification<Match> specification, Pageable pageable) {
        return matchService.getFilteredAndPagedMatches(specification, pageable).map(matchToMatchDtoConverter::convert);
    }

    @Override
    public MatchDto findById(int id) {
        return matchToMatchDtoConverter.convert(matchService.findById(id));
    }
}
