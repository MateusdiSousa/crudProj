package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import com.example.demo.domain.product.Product;
import com.example.demo.domain.product.ProductDto;
import com.example.demo.domain.product.ProductRepository;

import jakarta.transaction.Transactional;

@RestController()
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts(){	
		List<Product> products = productRepository.findAll();
		return ResponseEntity.ok(products);
	}
	
	@PostMapping
	public ResponseEntity<Product> createProduct( @RequestBody @Validated ProductDto data) {
		Product product = new Product(data);
		productRepository.save(product);
		return ResponseEntity.ok(product);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<Product> updateProduct(@RequestBody @Validated ProductDto productDtoUpdate){
		Optional<Product> response = productRepository.findById(productDtoUpdate.id());
		
		if(response.isPresent()) {
			Product product = response.get();
			product.setName(productDtoUpdate.name());
			product.setPrice(productDtoUpdate.price_in_cents());
			return ResponseEntity.ok(product);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteProduct(@RequestParam String id) {
		productRepository.deleteById(id);
		return ResponseEntity.ok("Deletado com sucesso!");
	}
}

