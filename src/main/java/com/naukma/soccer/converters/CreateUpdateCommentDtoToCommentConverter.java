package com.naukma.soccer.converters;

import com.naukma.soccer.dto.CreateUpdateCommentDto;
import com.naukma.soccer.entities.Comment;
import com.naukma.soccer.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUpdateCommentDtoToCommentConverter implements Converter<CreateUpdateCommentDto, Comment> {
    @Autowired
    private ArticleService articleService;

    @Override
    public Comment convert(CreateUpdateCommentDto commentDto) {
        return Comment.builder()
                .content(commentDto.getContent())
                .build();
    }
}
