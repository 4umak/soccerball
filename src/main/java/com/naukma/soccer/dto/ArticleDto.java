package com.naukma.soccer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class ArticleDto {
    private Integer id;
    private LocalDate create_date;
    private String content;
    private String image_link;
    private String championship;
    private String country;
    private String user;
}
