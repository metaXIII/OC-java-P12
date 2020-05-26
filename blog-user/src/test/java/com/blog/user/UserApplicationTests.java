package com.blog.user;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@Rollback
class UserApplicationTests {

    @Test
    void contextLoads() {
        assertDoesNotThrow(() -> UserApplication.main(new String[]{}));
    }

}
