package com.naukma.soccer.converters;

import com.naukma.soccer.dto.CreateUpdateArticleDto;
import com.naukma.soccer.entities.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUpdateArticleDtoToArticleConverter implements Converter<CreateUpdateArticleDto, Article> {

    @Autowired
    private CountryDtoToCountryConverter toCountryConverter;

    @Autowired
    private ChampionshipDtoToChampionshipConverter toChampionshipConverter;

    @Override
    public Article convert(CreateUpdateArticleDto createUpdateArticleDto) {
        return Article.builder()
                .id(createUpdateArticleDto.getId())
                .content(createUpdateArticleDto.getContent())
                .create_date(createUpdateArticleDto.getCreate_date())
                .image_link(createUpdateArticleDto.getImage_link())
                .championship(toChampionshipConverter.convert(createUpdateArticleDto.getChampionship()))
                .country(toCountryConverter.convert(createUpdateArticleDto.getCountry()))
                .build();
    }
}
