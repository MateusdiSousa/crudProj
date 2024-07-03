package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.product.Product;
import com.example.demo.domain.product.ProductDto;
import com.example.demo.domain.product.ProductRepository;

import netscape.javascript.JSObject;


@RestController()
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@GetMapping
	public ResponseEntity getAllProducts(){	
		List<Product> products = productRepository.findAll();
		return ResponseEntity.ok(products.toArray());
	}
	
	@PostMapping
	public ResponseEntity createProduct( @RequestBody @Validated ProductDto data) {
		Product product = new Product(data);
		var result = productRepository.save(product);
		return ResponseEntity.ok().build();
	}
}

