package com.naukma.soccer.controllers;

import com.naukma.soccer.entities.Country;
import com.naukma.soccer.facades.CountryFacade;
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
public class CountryControllerTest {
    @Mock
    CountryFacade countryFacade;
    @InjectMocks
    CountryController countryController = new CountryController();

    @Test
    public void testGetOne(){
        countryController.getOne(1);
        verify(countryFacade, times(1)).findById(1);
    }

    @Test
    public void testGetAll(){
        final Specification<Country> countryFilter = null ;
        Pageable pageable = PageRequest.of(0,20);
        countryController.getAll(countryFilter, pageable);
        verify(countryFacade, times(1)).findAll(countryFilter, pageable);
    }

}