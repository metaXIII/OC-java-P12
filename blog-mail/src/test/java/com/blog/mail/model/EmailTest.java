package com.blog.mail.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    private Email email;

    @BeforeEach
    public void init() {
        email = new Email();
        email.setSend(true);
        email.setEmail("aze");
        email.setId(1);
    }

    @Test
    void getId() {
        assertEquals(1, email.getId());
    }

    @Test
    void getEmail() {
        assertEquals("aze", email.getEmail());
    }

    @Test
    void isSend() {
        assertTrue(email.isSend());
    }

    @Test
    void setId() {
        assertDoesNotThrow(() -> email.setId(2));
    }

    @Test
    void setEmail() {
        assertDoesNotThrow(() -> email.setEmail("aze@aze"));
    }

    @Test
    void setSend() {
        assertDoesNotThrow(() -> email.setSend(false));
    }
}