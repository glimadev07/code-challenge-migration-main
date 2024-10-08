package com.example.dummyjson.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.Response;

@Service
public class ProductService {

	@Autowired
	private WebClient webClient;

	public ProductService() {
	}
	
	public ProductService(WebClient webClient) {
		this.webClient = webClient;
	}

	public List<Product> getAllProducts() {

		var response = webClient.get()
				.uri("/products")
				.retrieve()
				.bodyToMono(Response.class).block();
		return response.getProducts();
	}

	public Product getProductById(Long id) {
		return webClient.get()
				.uri("/products/{id}", id)
				.retrieve()
				.bodyToMono(Product.class).block();
	}
}
