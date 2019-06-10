package com.naukma.soccer.converters;

import com.naukma.soccer.dto.MatchDto;
import com.naukma.soccer.entities.Match;
import org.springframework.stereotype.Component;

@Component
public class MatchToMatchDtoConverter implements Converter<Match, MatchDto> {
    @Override
    public MatchDto convert(Match match) {
        return MatchDto.builder()
                .id(match.getId())
                .championship(match.getChampionship().getName())
                .match_date(match.getMatch_date())
                .t1_name(match.getT1_name())
                .t2_name(match.getT2_name())
                .score(match.getScore())
                .build();
    }
}
