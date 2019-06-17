package com.naukma.soccer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUpdateArticleDto {
    private Integer id;
    private LocalDate create_date;
    private String content;
    private String image_link;
    private ChampionshipDto championship;
    private CountryDto country;
}
