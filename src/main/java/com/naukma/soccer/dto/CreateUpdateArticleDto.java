package com.naukma.soccer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateUpdateArticleDto {
    private String name;
    private String content;
    private String image_link;
    private Integer championship;
    private Integer country;
}
