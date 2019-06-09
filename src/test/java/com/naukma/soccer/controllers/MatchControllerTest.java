package com.naukma.soccer.controllers;

import com.naukma.soccer.entities.Match;
import com.naukma.soccer.facades.MatchFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class MatchControllerTest {

    @Mock
    MatchFacade matchFacade;
    @InjectMocks
    MatchController matchController = new MatchController();

    @Test
    public void testGetOne(){
        matchController.findMatchById(1);
        verify(matchFacade, times(1)).findById(1);
    }

    @Test
    public void testGetAllFiltered(){
        final Specification<Match> matchFilter = null ;
        Pageable pageable = PageRequest.of(0,20);
        matchController.getFilteredMatches(matchFilter, pageable);
        verify(matchFacade, times(1)).getFilteredAndPagedMatches(matchFilter, pageable);
    }


}