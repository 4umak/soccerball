package com.naukma.soccer.services;

import com.naukma.soccer.entities.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface ArticleService {
    Page<Article> findAll(Specification<Article> articleSpecification, Pageable pageable);

    Article findById(int id);

    Article createArticle(Article article);
}
