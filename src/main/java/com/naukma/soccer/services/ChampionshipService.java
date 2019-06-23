package com.naukma.soccer.services;

import com.naukma.soccer.entities.Championship;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface ChampionshipService {
    Championship getOne(int id);

    Page<Championship> getAll(Specification<Championship> specification, Pageable pageable);
}
