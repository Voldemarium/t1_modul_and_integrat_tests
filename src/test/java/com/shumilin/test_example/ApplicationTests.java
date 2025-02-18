package com.shumilin.test_example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
class ApplicationTests {

    @Test
    @DisplayName(value = "Контекст успешно инициализируется")
    void contextLoads() {

    }

}