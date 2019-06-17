package com.naukma.soccer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class CommentDto {
    private int id;
    private Date create_date;
    private String content;
    private UserDto client;
    private ArticleDto article;
}
