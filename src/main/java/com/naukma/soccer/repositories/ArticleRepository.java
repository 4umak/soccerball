package com.naukma.soccer.repositories;

import com.naukma.soccer.entities.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Page<Article> findAll(Specification<Article> articleSpecification, Pageable pageable);
}
