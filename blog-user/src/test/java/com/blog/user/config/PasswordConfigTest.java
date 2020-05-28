package com.blog.user.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PasswordConfigTest {

    @InjectMocks
    private PasswordConfig passwordConfig;

    @Test
    void passwordEncoder() {
        assertDoesNotThrow(() -> passwordConfig.passwordEncoder());
        assertNotNull(passwordConfig.passwordEncoder());
    }
}