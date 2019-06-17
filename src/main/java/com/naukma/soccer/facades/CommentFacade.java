package com.naukma.soccer.facades;

import com.naukma.soccer.dto.CommentDto;

import java.util.List;

public interface CommentFacade {

    CommentDto getById(int id) throws Exception;
    List<CommentDto> getAllByArticleId(int id);
    List<CommentDto> getAllByUserId(int id);

}
