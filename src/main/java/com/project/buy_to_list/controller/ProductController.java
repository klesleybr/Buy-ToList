package com.project.buy_to_list.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
import com.project.buy_to_list.domain.product.ProductResponseDTO;
import com.project.buy_to_list.service.ProductService;

@RestController
@RequestMapping("/buy-tolist/api/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping(value = "/create-product", consumes = "multipart/form-data")
	public ResponseEntity<Product> createProduct(
				@RequestParam String title,
				@RequestParam String brand,
				@RequestParam(required = false) String description,
				@RequestParam(value = "image_url", required = false) MultipartFile image,
				@RequestParam(value = "user_id") UUID userId
			){
		
		ProductRequestDTO body = new ProductRequestDTO(title, brand, description, image);
		Product product = productService.createProduct(userId, body);
		return ResponseEntity.ok(product);
		
	}
	
	@GetMapping("/all-products")
	public ResponseEntity<List<ProductResponseDTO>> getAllProducts(@RequestParam(value = "user_id") UUID userId) {
		
		List<ProductResponseDTO> products = productService.getAllProducts(userId);		
		return ResponseEntity.ok(products);
		
	}
	
	@GetMapping("/all-products-pgs")
	public ResponseEntity<List<ProductResponseDTO>> getAllProducts(
			@RequestParam(value = "user_id") UUID userId, @RequestParam(defaultValue = "0") int page, 
			@RequestParam(defaultValue = "4") int size) {
		
		List<ProductResponseDTO> products = this.productService.getProductPages(userId, page, size);
		return ResponseEntity.ok(products);
		
	}
	
	@PatchMapping("/edit-product/{id}")
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
