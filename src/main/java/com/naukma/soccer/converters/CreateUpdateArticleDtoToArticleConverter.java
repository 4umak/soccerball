package com.naukma.soccer.converters;

import com.naukma.soccer.dto.CreateUpdateArticleDto;
import com.naukma.soccer.entities.Article;
import com.naukma.soccer.services.ChampionshipService;
import com.naukma.soccer.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class CreateUpdateArticleDtoToArticleConverter implements Converter<CreateUpdateArticleDto, Article> {
    @Autowired
    private ChampionshipService championshipService;

    @Autowired
    private CountryService countryService;

    @Override
    public Article convert(CreateUpdateArticleDto createUpdateArticleDto) {
        return Article.builder()
                .content(createUpdateArticleDto.getContent())
                .create_date(LocalDate.now())
                .image_link(createUpdateArticleDto.getImage_link())
                .name(createUpdateArticleDto.getName())
                .country(countryService.getOne(createUpdateArticleDto.getCountry()))
                .championship(championshipService.getOne(createUpdateArticleDto.getChampionship()))
                .build();
    }
}
