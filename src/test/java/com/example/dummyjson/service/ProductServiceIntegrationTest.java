package com.example.dummyjson.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.example.dummyjson.dto.Product;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductServiceIntegrationTest {

	@Autowired
    private ProductService productService;

    @Test
    void testGetProductById_Integration_Success() {
    	//Arrange
    	//Act
        Product product = productService.getProductById(1L);

        //Assert
        assertNotNull(product);
        assertEquals(1, product.getId());
        assertNotNull(product.getTitle());
    }
    
    @Test
    void testGetProductById_Integration_NotFound() {
        assertThrows(WebClientResponseException.NotFound.class, () -> {
            productService.getProductById(99999L);
        });
    }
}
