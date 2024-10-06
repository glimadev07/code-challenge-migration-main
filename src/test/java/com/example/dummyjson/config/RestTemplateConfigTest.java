package com.example.dummyjson.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RestTemplateConfigTest {

    @InjectMocks
    RestTemplateConfig restTemplateConfig;

    @Test
    public void testRestTemplateConfig() {
        assertNotNull(this.restTemplateConfig.restTemplate());
    }
}
