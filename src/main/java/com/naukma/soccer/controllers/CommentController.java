package com.naukma.soccer.controllers;

import com.naukma.soccer.dto.CommentDto;
import com.naukma.soccer.dto.CreateUpdateCommentDto;
import com.naukma.soccer.facades.CommentFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentFacade commentFacade;

    @GetMapping("/{id}")
    public CommentDto getCommentById(
            @NotNull @PathVariable final int id) throws Exception {
        return commentFacade.getById(id);
    }

    @GetMapping("article/{id}")
    public List<CommentDto> getAllByArticleId(@NotNull @PathVariable final int id) {
        return commentFacade.getAllByArticleId(id);
    }

    @GetMapping("user/{id}")
    public List<CommentDto> getAllByUserId(@NotNull @PathVariable final int id) {
        return commentFacade.getAllByUserId(id);
    }

    @PostMapping("/{newsId}/add")
    public CommentDto addComment(final CreateUpdateCommentDto commentDto, @PathVariable final int newsId) {
        return commentFacade.addComment(commentDto, newsId);
    }
}
