package com.blog.article.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

@SpringBootTest
@Rollback
@Transactional
@AutoConfigureMockMvc
class ArticleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ArticleController articleController;

    @Test
    void findAll() {
    }

    @Test
    void count() {
    }

    @Test
    void getById() {
    }

    @Test
    void insert() {
    }

    @Test
    void getListTags() {
    }

    @Test
    void search() {
    }

    @Test
    void getAllArticles() {
    }

    @Test
    void updateArticle() {
    }
}