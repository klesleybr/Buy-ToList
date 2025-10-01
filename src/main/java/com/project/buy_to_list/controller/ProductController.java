package com.project.buy_to_list.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.buy_to_list.domain.product.Product;
import com.project.buy_to_list.domain.product.ProductRequestDTO;
import com.project.buy_to_list.service.ProductService;

@RestController
@RequestMapping("/buy-tolist/api/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping(value = "/create-product", consumes = "multipart/form-data")
	public ResponseEntity<Product> createProduct(
				@RequestParam(value = "title") String title,
				@RequestParam(value = "brand") String brand,
				@RequestParam(value = "description", required = false) String description,
				@RequestParam(value = "imageUrl", required = false) MultipartFile image,
				@RequestParam(value = "userId") UUID userId
			){
		
		ProductRequestDTO body = new ProductRequestDTO(title, brand, description, image);
		Product product = productService.createProduct(userId, body);
		return ResponseEntity.ok(product);
		
	}
	
	@PatchMapping(value = "/edit-product/{id}")
	public ResponseEntity<Product> editProduct(@PathVariable UUID id, @RequestBody ProductRequestDTO body){
				
		Product product = productService.editProduct(id, body);
		return ResponseEntity.ok(product);
		
	}
	
	@DeleteMapping("/delete-product/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable UUID id){
		
		Product productDeleted = productService.deleteProduct(id);
		System.out.printf("Produto deletado: ", productDeleted.getTitle() + "\n");
		return ResponseEntity.ok(productDeleted);
		
	}

}
