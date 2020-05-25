package com.blog.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@Rollback
class GatewayApplicationTests {

    @Test
    void contextLoads() {
        assertDoesNotThrow(() -> GatewayApplication.main(new String[]{}));
    }

}
