package com.reddyong.testcicd;

import com.reddyong.testcicd.service.TestService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


@SpringBootTest
@ActiveProfiles("dev")
public class TestServiceImplTest {
    @Autowired
    private TestService testService;

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String applicationName;

    @Test
    void checkPortSuccess() {
        assertEquals(port, "3444");
    }

    @Test
    void checkPortFail() {
        assertNotEquals(port, "8080");
    }

    @Test
    void getTestStringSuccess() {
        assertEquals(testService.getTestString(), "OK develop server 3444");
    }

    @Test
    void getTestStringFail() {
        assertNotEquals(testService.getTestString(), "OK develop server 8080");
    }
}
