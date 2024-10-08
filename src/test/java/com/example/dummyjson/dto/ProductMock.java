package com.example.dummyjson.dto;

import java.util.Arrays;
import java.util.List;

public class ProductMock {

	public static Product getOne() {
		Product product = new Product();
		product.setId(1L);
		product.setTitle("Product 1");
		return product;
	}

	public static List<Product> getAll() {
		Product product1 = new Product();
		product1.setId(1L);
		product1.setTitle("Product 1");

		Product product2 = new Product();
		product2.setId(2L);
		product2.setTitle("Product 2");

		return Arrays.asList(product1, product2);
	}
}
