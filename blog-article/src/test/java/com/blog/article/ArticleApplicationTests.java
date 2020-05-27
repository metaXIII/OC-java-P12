package com.blog.article;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

@SpringBootTest
@Rollback
@Transactional
class ArticleApplicationTests {

    @Test
    void contextLoads() {
    }

}
