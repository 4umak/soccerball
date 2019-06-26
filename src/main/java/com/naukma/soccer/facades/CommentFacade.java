package com.naukma.soccer.facades;

import com.naukma.soccer.dto.CommentDto;
import com.naukma.soccer.dto.CreateUpdateCommentDto;

import java.util.List;

public interface CommentFacade {

    CommentDto getById(int id) throws Exception;

    List<CommentDto> getAllByArticleId(int id);

    List<CommentDto> getAllByUserId(int id);

    CommentDto addComment(CreateUpdateCommentDto commentDto, final int newsId);
}
