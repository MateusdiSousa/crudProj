package com.example.demo.domain.product;

public record ProductDto(
		String id,
		String name,
		Integer price_in_cents
){}
