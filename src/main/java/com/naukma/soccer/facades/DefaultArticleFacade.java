package com.naukma.soccer.facades;

import com.naukma.soccer.converters.ArticleToArticleDtoConverter;
import com.naukma.soccer.converters.CreateUpdateArticleDtoToArticleConverter;
import com.naukma.soccer.dto.ArticleDto;
import com.naukma.soccer.dto.CreateUpdateArticleDto;
import com.naukma.soccer.entities.Article;
import com.naukma.soccer.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class DefaultArticleFacade implements ArticleFacade {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleToArticleDtoConverter articleToArticleDtoConverter;

    @Autowired
    private CreateUpdateArticleDtoToArticleConverter toArticleConverter;


    @Override
    public Page<ArticleDto> getFilteredArticles(final Specification<Article> articleSpecification, final Pageable pageable) {
        return articleService.findAll(articleSpecification, pageable).map(articleToArticleDtoConverter::convert);
    }

    @Override
    public ArticleDto getArticleById(final int id) {
        return articleToArticleDtoConverter.convert(articleService.findById(id));
    }

    @Override
    public ArticleDto createArticle(final CreateUpdateArticleDto createUpdateArticleDto) {
        return articleToArticleDtoConverter.convert(articleService.createArticle(toArticleConverter.convert(createUpdateArticleDto)));
    }
}
