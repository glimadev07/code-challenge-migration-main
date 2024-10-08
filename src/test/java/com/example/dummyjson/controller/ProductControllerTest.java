package com.example.dummyjson.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.ProductMock;
import com.example.dummyjson.service.ProductService;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

	@InjectMocks
	private ProductController productController;

	@Mock
	private ProductService productService;

	@Test
	public void testGetAllProducts() {
		// Arrange
		when(productService.getAllProducts()).thenReturn(ProductMock.getAll());

		// Act
		List<Product> result = productController.getAllProducts();

		// Assert
		assertEquals(2, result.size());
		assertEquals("Product 1", result.get(0).getTitle());
	}

	@Test
	public void testGetProductById() {
		// Arrange
		when(productService.getProductById(1L)).thenReturn(ProductMock.getOne());

		// Act
		Product result = productController.getProductById(1L);

		// Assert
		assertEquals("Product 1", result.getTitle());
	}
}
