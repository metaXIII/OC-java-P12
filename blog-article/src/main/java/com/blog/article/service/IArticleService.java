package com.blog.article.service;

import com.blog.article.dto.ArticleDto;
import com.blog.article.exception.ArticleException;
import com.blog.article.model.Article;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

public interface IArticleService {
    List<Article> findAllForPageLimit(int page, int number);

    List<Article> findAll();

    Article findById(long id) throws ArticleException;

    void insert(ArticleDto articleDto) throws UserPrincipalNotFoundException;

    List<Article> findByCategorie(String category);
}
