package com.naukma.soccer.services;

import com.naukma.soccer.entities.Comment;
import com.naukma.soccer.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCommentService implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment getById(int id) throws Exception {
        return commentRepository.findById(id).orElseThrow(() -> new Exception("There is no comment by this id"));
    }

    @Override
    public List<Comment> getAllByArticleId(int id) {
        return commentRepository.findAllByArticle_Id(id);
    }

    @Override
    public List<Comment> getAllByUserId(int id) {
        return commentRepository.findAllByClient_Id(id);
    }
}
