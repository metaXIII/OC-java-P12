package com.blog.user.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    private User user;

    @BeforeEach
    public void init() {
        user = new User();
        user.setId(1);
        user.setEnvironnement("aze");
        user.setAbout("aze");
        user.setEmail("aze@aze");
        user.setTwitter("aze");
        user.setLinkedin("aze");
        user.setGithub("aze");
        user.setUsernamePublic("aze");
        user.setUsername("aze");
        user.setPassword("aze");
    }

    @Test
    void getAuthorities() {
        assertDoesNotThrow(() -> user.getAuthorities());
    }

    @Test
    void isAccountNonExpired() {
        assertDoesNotThrow(() -> user.isAccountNonExpired());
    }

    @Test
    void isAccountNonLocked() {
        assertDoesNotThrow(() -> user.isAccountNonLocked());
    }

    @Test
    void isCredentialsNonExpired() {
        assertDoesNotThrow(() -> user.isCredentialsNonExpired());
    }

    @Test
    void isEnabled() {
        assertDoesNotThrow(() -> user.isEnabled());
    }

    @Test
    void getId() {
        assertEquals(1, user.getId());
    }

    @Test
    void getUsername() {
        assertEquals("aze", user.getUsername());
    }


    @Test
    void getEmail() {
        assertEquals("aze@aze", user.getEmail());
    }

    @Test
    void getUsernamePublic() {
        assertEquals("aze", user.getUsernamePublic());
    }

    @Test
    void getPassword() {
        assertEquals("aze", user.getPassword());
    }

    @Test
    void getTwitter() {
        assertEquals("aze", user.getTwitter());
    }

    @Test
    void getLinkedin() {
        assertEquals("aze", user.getLinkedin());
    }

    @Test
    void getGithub() {
        assertEquals("aze", user.getGithub());
    }

    @Test
    void getAbout() {
        assertEquals("aze", user.getAbout());
    }

    @Test
    void getEnvironnement() {
        assertEquals("aze", user.getEnvironnement());
    }

    @Test
    void setId() {
        assertDoesNotThrow(() -> user.setId(1L));
    }

    @Test
    void setUsername() {
        assertDoesNotThrow(() -> user.setUsername("aze2"));
    }

    @Test
    void setEmail() {
        assertDoesNotThrow(() -> user.setEmail("aze2"));
    }

    @Test
    void setUsernamePublic() {
        assertDoesNotThrow(() -> user.setUsernamePublic("aze2"));
    }

    @Test
    void setPassword() {
        assertDoesNotThrow(() -> user.setPassword("aze2"));
    }

    @Test
    void setTwitter() {
        assertDoesNotThrow(() -> user.setTwitter("aze2"));
    }

    @Test
    void setLinkedin() {
        assertDoesNotThrow(() -> user.setLinkedin("aze2"));
    }

    @Test
    void setGithub() {
        assertDoesNotThrow(() -> user.setGithub("aze2"));
    }

    @Test
    void setAbout() {
        assertDoesNotThrow(() -> user.setAbout("aze2"));
    }

    @Test
    void setEnvironnement() {
        assertDoesNotThrow(() -> user.setEnvironnement("aze2"));
    }
}