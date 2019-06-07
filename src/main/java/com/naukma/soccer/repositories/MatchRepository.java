package com.naukma.soccer.repositories;

import com.naukma.soccer.entities.Match;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {
    Page<Match> findAll(Specification<Match> matchSpecification, Pageable pageable);
}
