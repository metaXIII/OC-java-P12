package com.blog.article.dto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArticleDtoTest {
    private ArticleDto articleDto;

    @BeforeEach
    public void init() {
        articleDto = new ArticleDto();
        articleDto.setTitre("");
        articleDto.setTags("");
        articleDto.setSynopsis("");
        articleDto.setControl("");
        articleDto.setContent("");
    }

    @AfterEach
    public void end() {
        articleDto = null;
    }

    @Test
    void setTitre() {
        assertDoesNotThrow(() -> articleDto.setTitre("aze"));
    }

    @Test
    void setSynopsis() {
        assertDoesNotThrow(() -> articleDto.setSynopsis("aze"));
    }

    @Test
    void setTags() {
        assertDoesNotThrow(() -> articleDto.setTags("aze"));
    }

    @Test
    void setContent() {
        assertDoesNotThrow(() -> articleDto.setContent("aze"));
    }

    @Test
    void setControl() {
        assertDoesNotThrow(() -> articleDto.setControl("aze"));
    }

    @Test
    void getTitre() {
        assertEquals("", articleDto.getTitre());
    }

    @Test
    void getSynopsis() {
        assertEquals("", articleDto.getSynopsis());
    }

    @Test
    void getTags() {
        assertEquals("", articleDto.getTags());
    }

    @Test
    void getContent() {
        assertEquals("", articleDto.getContent());
    }

    @Test
    void getControl() {
        assertEquals("", articleDto.getControl());
    }
}