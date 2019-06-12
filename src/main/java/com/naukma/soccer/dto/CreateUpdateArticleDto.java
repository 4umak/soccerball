package com.naukma.soccer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
public class CreateUpdateArticleDto {
    private Integer id;
    private Date create_date;
    private String content;
    private String image_link;
    private ChampionshipDto championship;
    private CountryDto country;
}
