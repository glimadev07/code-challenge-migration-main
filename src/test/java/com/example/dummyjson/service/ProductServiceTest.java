package com.example.dummyjson.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.Response;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

	@InjectMocks
	private ProductService productService;

	@Mock
	private WebClient webClient;
	

	@BeforeEach
	public void setUp() {
	}

	@Test
	public void testGetAllProducts() {
		Product product1 = new Product();
		product1.setId(1L);
		product1.setTitle("Product 1");

		Product product2 = new Product();
		product2.setId(2L);
		product2.setTitle("Product 2");

		Response response = new Response(Arrays.asList(product1, product2));

		when(webClient.get().uri("/products").retrieve().bodyToMono(Response.class).block()).thenReturn(response);

		List<Product> result = productService.getAllProducts();
		assertEquals(2, result.size());
		assertEquals("Product 1", result.get(0).getTitle());
	}

	@Test
	public void testGetProductById() {
		Product product = new Product();
		product.setId(1L);
		product.setTitle("Product 1");

		when(webClient.get().uri("/products").retrieve().bodyToMono(Product.class).block()).thenReturn(product);

		Product result = productService.getProductById(1L);
		assertEquals("Product 1", result.getTitle());
	}
}
