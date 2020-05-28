package com.blog.mail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@Rollback
@Transactional
class MailApplicationTests {

    @Test
    void contextLoads() {
        assertDoesNotThrow(() -> MailApplication.main(new String[]{}));
    }

}
