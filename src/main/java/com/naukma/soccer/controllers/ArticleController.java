package com.naukma.soccer.controllers;

import com.naukma.soccer.dto.ArticleDto;
import com.naukma.soccer.dto.CreateUpdateArticleDto;
import com.naukma.soccer.entities.Article;
import com.naukma.soccer.facades.ArticleFacade;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.domain.StartingWith;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleFacade articleFacade;

    @GetMapping
    public Page<ArticleDto> getFilteredArticles(@And({
            @Spec(path = "championship", spec = StartingWith.class),
            @Spec(path = "country", spec = LikeIgnoreCase.class),
            @Spec(path = "user", spec = LikeIgnoreCase.class),
    }) final Specification<Article> articleSpecification, final Pageable pageable) {
        return articleFacade.getFilteredArticles(articleSpecification, pageable);
    }

    @GetMapping("/{id}")
    public ArticleDto getArticleById(@PathVariable
                                     @NotNull final int id) {
        return articleFacade.getArticleById(id);
    }

    @PostMapping("/")
    public ArticleDto createArticle(@Valid
                                    @RequestBody final CreateUpdateArticleDto createUpdateArticleDto) {
        return articleFacade.createArticle(createUpdateArticleDto);
    }


}