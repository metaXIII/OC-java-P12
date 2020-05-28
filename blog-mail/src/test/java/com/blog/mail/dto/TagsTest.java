package com.blog.mail.dto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TagsTest {

    private Tags tags;

    @BeforeEach
    public void init() {
        tags = new Tags();
        tags.setId(1);
        tags.setTag("aze");
    }

    @AfterEach
    public void end() {
        tags = null;
    }

    @Test
    void getId() {
        assertEquals(1, tags.getId());
    }

    @Test
    void getTag() {
        assertEquals("aze", tags.getTag());
    }

    @Test
    void setId() {
        assertDoesNotThrow(() -> tags.setId(2));
    }

    @Test
    void setTag() {
        assertDoesNotThrow(() -> tags.setTag("azeaze"));
    }
}