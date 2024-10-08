package com.example.dummyjson.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.ProductMock;
import com.example.dummyjson.dto.Response;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

	@Mock
    private WebClient webClientMock;

    @SuppressWarnings("rawtypes")
	@Mock
    private RequestHeadersUriSpec requestHeadersUriSpecMock;

    @Mock
    private ResponseSpec responseSpecMock;
    
	@InjectMocks
	private ProductService productService;
	

	@BeforeEach
	public void setUp() {
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetAllProducts() {
		//Arrange
		Response response = new Response(ProductMock.getAll());

		when(webClientMock.get()).thenReturn(requestHeadersUriSpecMock);
        when(requestHeadersUriSpecMock.uri("/products")).thenReturn(requestHeadersUriSpecMock);
        when(requestHeadersUriSpecMock.retrieve()).thenReturn(responseSpecMock);
        when(responseSpecMock.bodyToMono(Response.class)).thenReturn(Mono.just(response));

        //Act
		List<Product> result = productService.getAllProducts();
		
		//Assert
		assertEquals(2, result.size());
		assertEquals("Product 1", result.get(0).getTitle());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetProductById() {
		//Arrange

		when(webClientMock.get()).thenReturn(requestHeadersUriSpecMock);
        when(requestHeadersUriSpecMock.uri("/products/{id}", 1L)).thenReturn(requestHeadersUriSpecMock);
        when(requestHeadersUriSpecMock.retrieve()).thenReturn(responseSpecMock);
        when(responseSpecMock.bodyToMono(Product.class)).thenReturn(Mono.just(ProductMock.getOne()));

        //Act
		Product result = productService.getProductById(1L);
		
		//Assert
		assertEquals("Product 1", result.getTitle());
	}
}
