package com.blog.article.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticleUpdateDtoTest {

    private ArticleUpdateDto articleUpdateDto;

    @BeforeEach
    public void init() {
        articleUpdateDto = new ArticleUpdateDto();
        articleUpdateDto.setContent("");
        articleUpdateDto.setControl("");
        articleUpdateDto.setId(1);
        articleUpdateDto.setSynopsis("");
        articleUpdateDto.setTags("");
        articleUpdateDto.setTitre("");
    }

    @Test
    void setId() {
        assertDoesNotThrow(() -> articleUpdateDto.setId(2));
    }

    @Test
    void setTitre() {
        assertDoesNotThrow(() -> articleUpdateDto.setTitre("aze"));
    }

    @Test
    void setSynopsis() {
        assertDoesNotThrow(() -> articleUpdateDto.setSynopsis("aze"));
    }

    @Test
    void setTags() {
        assertDoesNotThrow(() -> articleUpdateDto.setTags("aze"));
    }

    @Test
    void setContent() {
        assertDoesNotThrow(() -> articleUpdateDto.setContent("aze"));
    }

    @Test
    void setControl() {
        assertDoesNotThrow(() -> articleUpdateDto.setControl("aze"));
    }

    @Test
    void getId() {
        assertEquals(1, articleUpdateDto.getId());
    }

    @Test
    void getTitre() {
        assertNotNull(articleUpdateDto.getTitre());
    }

    @Test
    void getSynopsis() {
        assertNotNull(articleUpdateDto.getSynopsis());
    }

    @Test
    void getTags() {
        assertNotNull(articleUpdateDto.getTags());
    }

    @Test
    void getContent() {
        assertNotNull(articleUpdateDto.getContent());
    }

    @Test
    void getControl() {
        assertNotNull(articleUpdateDto.getControl());
    }
}