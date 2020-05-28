package com.blog.mail.dto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ArticleDtoTest {
    private ArticleDto articleDto;

    @BeforeEach
    public void init() {
        articleDto = new ArticleDto();
        articleDto.setTitre("");
        articleDto.setTags(new Tags());
        articleDto.setSynopsis("");
        articleDto.setLocalDate(LocalDate.now());
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
        assertDoesNotThrow(() -> articleDto.setTags(new Tags()));
    }

    @Test
    void setContent() {
        assertDoesNotThrow(() -> articleDto.setContent("aze"));
    }

    @Test
    void setControl() {
        assertDoesNotThrow(() -> articleDto.setLocalDate(LocalDate.now()));
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
        assertNotNull(articleDto.getTags());
    }

    @Test
    void getContent() {
        assertEquals("", articleDto.getContent());
    }

    @Test
    void getLocalDate() {
        assertNotNull(articleDto.getLocalDate());
    }
}