package com.naukma.soccer.converters;

import com.naukma.soccer.dto.ArticleDto;
import com.naukma.soccer.entities.Article;
import org.springframework.stereotype.Component;

@Component
public class ArticleToArticleDtoConverter implements Converter<Article, ArticleDto> {
    @Override
    public ArticleDto convert(Article article) {
        return ArticleDto.builder()
                .id(article.getId())
                .championship(article.getChampionship() == null ? "" : article.getChampionship().getName())
                .content(article.getContent())
                .country(article.getCountry() == null ? "" : article.getCountry().getName())
                .create_date(article.getCreate_date())
                .image_link(article.getImage_link())
                .user(article.getUser().getEmail())
                .name(article.getName())
                .build();
    }
}
