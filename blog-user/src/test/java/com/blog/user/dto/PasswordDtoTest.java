package com.blog.user.dto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PasswordDtoTest {

    private PasswordDto passwordDto;

    @BeforeEach
    public void init() {
        passwordDto = new PasswordDto();
        passwordDto.setNewPassword("aze");
        passwordDto.setPassword("aze");
        passwordDto.setUsername("aze");
    }

    @AfterEach
    public void end() {
        passwordDto = null;
    }


    @Test
    void getPassword() {
        assertEquals("aze", passwordDto.getPassword());
    }

    @Test
    void getNewPassword() {
        assertEquals("aze", passwordDto.getNewPassword());
    }

    @Test
    void getUsername() {
        assertEquals("aze", passwordDto.getUsername());
    }

    @Test
    void setPassword() {
        assertDoesNotThrow(() -> passwordDto.setPassword("azeaze"));
    }

    @Test
    void setNewPassword() {
        assertDoesNotThrow(() -> passwordDto.setNewPassword("azeaze"));
    }

    @Test
    void setUsername() {
        assertDoesNotThrow(() -> passwordDto.setUsername("azeaze"));
    }
}