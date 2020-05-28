package com.blog.mail.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailDtoTest {

    private EmailDto emailDto;

    @BeforeEach
    public void init() {
        emailDto = new EmailDto();
        emailDto.setEmail("aze");
    }

    @Test
    void getEmail() {
        assertEquals("aze", emailDto.getEmail());
    }

    @Test
    void setEmail() {
        assertDoesNotThrow(() -> emailDto.setEmail("aze@aze"));
    }
}