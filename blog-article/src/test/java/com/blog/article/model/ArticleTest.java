package com.blog.article.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ArticleTest {

    private Article article;

    @BeforeEach
    public void init() {
        article = new Article();
        article.setTitre("");
        article.setTags(new Tags());
        article.setSynopsis("");
        article.setLocalDate(LocalDate.now());
        article.setContent("");
    }

    @AfterEach
    public void end() {
        article = null;
    }

    @Test
    void setTitre() {
        assertDoesNotThrow(() -> article.setTitre("aze"));
    }

    @Test
    void setSynopsis() {
        assertDoesNotThrow(() -> article.setSynopsis("aze"));
    }

    @Test
    void setTags() {
        assertDoesNotThrow(() -> article.setTags(new Tags()));
    }

    @Test
    void setContent() {
        assertDoesNotThrow(() -> article.setContent("aze"));
    }

    @Test
    void setControl() {
        assertDoesNotThrow(() -> article.setLocalDate(LocalDate.now()));
    }

    @Test
    void getTitre() {
        assertEquals("", article.getTitre());
    }

    @Test
    void getSynopsis() {
        assertEquals("", article.getSynopsis());
    }

    @Test
    void getTags() {
        assertNotNull(article.getTags());
    }

    @Test
    void getContent() {
        assertEquals("", article.getContent());
    }

    @Test
    void getLocalDate() {
        assertNotNull(article.getLocalDate());
    }
}