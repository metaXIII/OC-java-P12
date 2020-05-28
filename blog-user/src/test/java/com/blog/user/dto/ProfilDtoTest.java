package com.blog.user.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProfilDtoTest {

    private ProfilDto profilDto;

    @BeforeEach
    public void init() {
        profilDto = new ProfilDto();
        profilDto.setAbout("aze");
        profilDto.setControl("aze");
        profilDto.setEnvironnement("aze");
    }

    @Test
    void getAbout() {
        assertEquals("aze", profilDto.getAbout());
    }

    @Test
    void getEnvironnement() {
        assertEquals("aze", profilDto.getEnvironnement());
    }

    @Test
    void getControl() {
        assertEquals("aze", profilDto.getControl());
    }

    @Test
    void setAbout() {
        assertDoesNotThrow(() -> profilDto.setAbout("azeaze"));
    }

    @Test
    void setEnvironnement() {
        assertDoesNotThrow(() -> profilDto.setEnvironnement("azeaze"));
    }

    @Test
    void setControl() {
        assertDoesNotThrow(() -> profilDto.setControl("azeaze"));
    }
}