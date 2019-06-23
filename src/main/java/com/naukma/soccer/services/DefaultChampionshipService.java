package com.naukma.soccer.services;

import com.naukma.soccer.entities.Championship;
import com.naukma.soccer.exceptions.NoSuchEntityException;
import com.naukma.soccer.repositories.ChampionshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultChampionshipService implements ChampionshipService {

    @Autowired
    private ChampionshipRepository championshipRepository;

    @Override
    public Championship getOne(final int id) {
        Optional<Championship> found = championshipRepository.findById(id);
        return found.orElseThrow(() -> new NoSuchEntityException(String
                .format("The championship with id %s was not found", id)));
    }

    @Override
    public Page<Championship> getAll(final Specification<Championship> specification, final Pageable pageable) {
        return championshipRepository.findAll(specification, pageable);
    }
}
