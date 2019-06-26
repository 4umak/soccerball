package com.naukma.soccer.services;

import com.naukma.soccer.entities.Article;
import com.naukma.soccer.entities.Client;
import com.naukma.soccer.entities.Comment;

import java.util.List;

public interface CommentService {

    Comment getById(int id) throws Exception;

    List<Comment> getAllByArticleId(int id);

    List<Comment> getAllByUserId(int id);

    Comment addComment(Client user, Comment comment, Article article);

}
