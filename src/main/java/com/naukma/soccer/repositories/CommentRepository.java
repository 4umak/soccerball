package com.naukma.soccer.repositories;

import com.naukma.soccer.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Override
    Optional<Comment> findById(Integer integer);

    List<Comment> findAllByClient_Id(Integer id);

    List<Comment> findAllByArticle_Id(Integer id);
}
