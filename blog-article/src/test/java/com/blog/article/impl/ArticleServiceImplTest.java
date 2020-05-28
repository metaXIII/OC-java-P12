package com.blog.article.impl;

import com.blog.article.dto.ArticleDto;
import com.blog.article.dto.ArticleUpdateDto;
import com.blog.article.exception.ArticleException;
import com.blog.article.model.Article;
import com.blog.article.proxy.GatewayProxy;
import com.blog.article.repository.ArticleRepository;
import com.blog.article.repository.ArticleRepositoryPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ArticleServiceImplTest {

    @InjectMocks
    private ArticleServiceImpl articleService;

    @Mock
    private ArticleRepository articleRepository;

    @Mock
    private ArticleRepositoryPage articleRepositoryPage;

    @Mock
    private GatewayProxy gatewayProxy;

    @Test
    void findAllForPageLimit() {
        Page<Article> stream = new PageImpl<>(Collections.EMPTY_LIST);
        when(articleRepositoryPage.findAll(any(PageRequest.class))).thenReturn(stream);
        assertDoesNotThrow(() -> articleService.findAllForPageLimit(1, 1));
    }

    @Test
    void findAll() {
        assertDoesNotThrow(() -> articleService.findAll());
    }

    @Test
    void findById() {
        assertThrows(ArticleException.class, () -> articleService.findById(1L));
    }

    @Test
    void insert() {
        assertDoesNotThrow(() -> articleService.insert(new ArticleDto()));
    }

    @Test
    void findByCategorie() {
        assertDoesNotThrow(() -> articleService.findByCategorie("aze"));
    }

    @Test
    void findAllForAdmin() {
        assertDoesNotThrow(() -> articleService.findAllForAdmin());
    }

    @Test
    void update() {
        assertDoesNotThrow(() -> articleService.update(new ArticleUpdateDto()));
    }
}