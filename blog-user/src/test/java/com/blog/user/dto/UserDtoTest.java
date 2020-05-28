package com.blog.user.dto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserDtoTest {

    private UserDto userDto;

    @BeforeEach
    public void init() {
        userDto = new UserDto();
        userDto.setControl("aze");
        userDto.setEmail("aze");
        userDto.setGithub("aze");
        userDto.setLinkedin("aze");
        userDto.setTwitter("aze");
        userDto.setUsername("aze");
        userDto.setUsernamePublic("aze");
    }

    @AfterEach
    public void end() {
        userDto = null;
    }

    @Test
    void getUsername() {
        assertEquals("aze", userDto.getUsername());
    }

    @Test
    void getUsernamePublic() {
        assertEquals("aze", userDto.getUsernamePublic());
    }

    @Test
    void getGithub() {
        assertEquals("aze", userDto.getGithub());
    }

    @Test
    void getLinkedin() {
        assertEquals("aze", userDto.getLinkedin());
    }

    @Test
    void getTwitter() {
        assertEquals("aze", userDto.getTwitter());
    }

    @Test
    void getEmail() {
        assertEquals("aze", userDto.getEmail());
    }

    @Test
    void getControl() {
        assertEquals("aze", userDto.getControl());
    }

    @Test
    void setUsername() {
        assertDoesNotThrow(() -> userDto.setUsername("azeaze"));
    }

    @Test
    void setUsernamePublic() {
        assertDoesNotThrow(() -> userDto.setUsernamePublic("azeaze"));
    }

    @Test
    void setGithub() {
        assertDoesNotThrow(() -> userDto.setGithub("azeaze"));
    }

    @Test
    void setLinkedin() {
        assertDoesNotThrow(() -> userDto.setLinkedin("azeaze"));
    }


    @Test
    void setTwitter() {
        assertDoesNotThrow(() -> userDto.setTwitter("azeaze"));
    }

    @Test
    void setEmail() {
        assertDoesNotThrow(() -> userDto.setEmail("azeaze"));
    }

    @Test
    void setControl() {
        assertDoesNotThrow(() -> userDto.setControl("azeaze"));
    }
}