package com.naukma.soccer.repositories;

import com.naukma.soccer.entities.Championship;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChampionshipRepository extends JpaRepository<Championship, Integer> {
    Page<Championship> findAll(Specification<Championship> specification, Pageable pageable);
}
