package com.naukma.soccer.facades;

import com.naukma.soccer.dto.ArticleDto;
import com.naukma.soccer.dto.CreateUpdateArticleDto;
import com.naukma.soccer.entities.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface ArticleFacade {
    Page<ArticleDto> getFilteredArticles(Specification<Article> articleSpecification, Pageable pageable);
    ArticleDto getArticleById(int id);
    ArticleDto createArticle(CreateUpdateArticleDto createUpdateArticleDto);
}
