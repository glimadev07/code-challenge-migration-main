package com.example.dummyjson.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {

	@JsonProperty("products")
	private List<Product> products;

	public Response() {
	}

	public Response(List<Product> products) {
		this.products = products;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Response [products=" + products + "]";
	}

}
