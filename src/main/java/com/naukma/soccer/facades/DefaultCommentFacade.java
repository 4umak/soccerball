package com.naukma.soccer.facades;

import com.naukma.soccer.converters.CommentToCommentDtoConverter;
import com.naukma.soccer.converters.CreateUpdateCommentDtoToCommentConverter;
import com.naukma.soccer.dto.CommentDto;
import com.naukma.soccer.dto.CreateUpdateCommentDto;
import com.naukma.soccer.entities.Article;
import com.naukma.soccer.entities.Client;
import com.naukma.soccer.entities.Comment;
import com.naukma.soccer.exceptions.NoSuchEntityException;
import com.naukma.soccer.services.ArticleService;
import com.naukma.soccer.services.CommentService;
import com.naukma.soccer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultCommentFacade implements CommentFacade {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentToCommentDtoConverter dtoConverter;

    @Autowired
    private CreateUpdateCommentDtoToCommentConverter toCommentConverter;

    @Override
    public CommentDto getById(int id) throws Exception {
        return dtoConverter.convert(commentService.getById(id));
    }

    @Override
    public List<CommentDto> getAllByArticleId(int id) {
        List<CommentDto> commentDtoList = new ArrayList<>();
        for (Comment comment : commentService.getAllByArticleId(id)) {
            commentDtoList.add(dtoConverter.convert(comment));
        }
        return commentDtoList;
    }

    @Override
    public List<CommentDto> getAllByUserId(int id) {
        List<CommentDto> commentDtoList = new ArrayList<>();
        for (Comment comment : commentService.getAllByUserId(id)) {
            commentDtoList.add(dtoConverter.convert(comment));
        }
        return commentDtoList;
    }

    @Override
    public CommentDto addComment(final CreateUpdateCommentDto commentDto, final int newsId) {
        Client user = userService.getSessionUser();
        if (user == null)
            throw new NoSuchEntityException("You don't have any current user");
        Article article = articleService.findById(newsId);
        return dtoConverter.convert(commentService.addComment(user, toCommentConverter.convert(commentDto), article));
    }
}
