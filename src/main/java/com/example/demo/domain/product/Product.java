package com.example.demo.domain.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Table(name="product")
@Entity(name="product")
public class Product {
	@Id 
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	
	private String name;
		
	private Integer price_in_cents;
	
	public String getName() {
		return this.name;
	}
	
	public String getId() {
		return this.id;
	}
	
	public Integer getPrice() {
		return this.price_in_cents;
	}
	
	public Product(ProductDto dto) {
		this.name = dto.name();
		this.price_in_cents = dto.price_in_cents();
	}
	
	public Product(String id, String name, Integer price_in_cents) {
		this.name = name;
		this.id = id;
		this.price_in_cents = price_in_cents;
	}
	
	public Product() {}
}
		
