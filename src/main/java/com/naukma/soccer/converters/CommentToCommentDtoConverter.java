package com.naukma.soccer.converters;

import com.naukma.soccer.dto.CommentDto;
import com.naukma.soccer.entities.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentToCommentDtoConverter implements Converter<Comment, CommentDto> {

    @Autowired
    private UserToUserDtoConverter userDtoConverter;

    @Autowired
    private ArticleToArticleDtoConverter articleDtoConverter;

    @Override
    public CommentDto convert(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .create_date(comment.getCreate_date())
                .client(userDtoConverter.convert(comment.getClient()))
                .article(articleDtoConverter.convert(comment.getArticle()))
                .build();
    }
}
