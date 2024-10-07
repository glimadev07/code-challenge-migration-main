package com.example.dummyjson.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;

@ExtendWith(MockitoExtension.class)
public class WebClientConfigTest {

	@InjectMocks
	WebClientConfig webClientConfig;

	@Test
	public void testRestTemplateConfig() {
		// Arrange
		// Act
		var webClient = this.webClientConfig.webClient(WebClient.builder());

		// Assert
		assertNotNull(webClient);
	}
}
