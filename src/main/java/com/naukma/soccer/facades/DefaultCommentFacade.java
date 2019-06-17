package com.naukma.soccer.facades;

import com.naukma.soccer.converters.CommentToCommentDtoConverter;
import com.naukma.soccer.dto.CommentDto;
import com.naukma.soccer.entities.Comment;
import com.naukma.soccer.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultCommentFacade implements CommentFacade {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentToCommentDtoConverter dtoConverter;

    @Override
    public CommentDto getById(int id) throws Exception {
        return dtoConverter.convert(commentService.getById(id));
    }

    @Override
    public List<CommentDto> getAllByArticleId(int id) {
        List<CommentDto> commentDtoList = new ArrayList<>();
        for(Comment comment : commentService.getAllByArticleId(id)) {
            commentDtoList.add(dtoConverter.convert(comment));
        }
        return commentDtoList;
    }

    @Override
    public List<CommentDto> getAllByUserId(int id) {
        List<CommentDto> commentDtoList = new ArrayList<>();
        for(Comment comment : commentService.getAllByUserId(id)) {
            commentDtoList.add(dtoConverter.convert(comment));
        }
        return commentDtoList;
    }
}
