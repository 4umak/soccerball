package com.naukma.soccer.services;

import com.naukma.soccer.entities.Article;
import com.naukma.soccer.entities.Client;
import com.naukma.soccer.exceptions.EntityExistsException;
import com.naukma.soccer.exceptions.NoSuchEntityException;
import com.naukma.soccer.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class DefaultArticleService implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserService userService;

    @Override
    public Page<Article> findAll(final Specification<Article> articleSpecification, final Pageable pageable) {
        return articleRepository.findAll(articleSpecification, pageable);
    }

    @Override
    public Article findById(final int id) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        return optionalArticle.orElseThrow(() -> new NoSuchEntityException(String
                .format("The article with id %s was not found", id)));
    }

    @Override
    public Article createArticle(final Article article) {
        if (articleRepository.existsById(article.getId()))
            throw new EntityExistsException(String.format("Article with id %s already exists", article.getId()));
        Client user = userService.getSessionUser();
        article.setUser(user);
        article.setCreate_date(LocalDate.now());
        return articleRepository.save(article);
    }
}
