package com.project.buy_to_list.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.buy_to_list.domain.product.Product;
import com.project.buy_to_list.domain.product.ProductRequestDTO;
import com.project.buy_to_list.domain.product.ProductResponseDTO;
import com.project.buy_to_list.domain.user.User;
import com.project.buy_to_list.repositories.ProductRepository;
import com.project.buy_to_list.repositories.UserRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private UserRepository userRepository;
	private UserService userService = new UserService();
	
	public Product createProduct(UUID userId, ProductRequestDTO productData) {

		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("ERRO - Usuário não encontrado."));
		
		String imageUrl = null;
		if(productData.image() != null) {
			imageUrl = this.userService.uploadImage(productData.image());
		}
		
		Product product = new Product(productData.title(), productData.brand(), productData.description(), imageUrl, user);
		this.productRepository.save(product);
		
		return product;
		
	}
	
	public List<ProductResponseDTO> getAllProducts(UUID userId) {
		
		List<Product> products = this.productRepository.findProductsByUser(userId);
		List<ProductResponseDTO> allProductsInList = new ArrayList<>();
		
		for(Product product : products) {
			allProductsInList.add(new ProductResponseDTO(product.getId(), product.getTitle(), product.getBrand(), 
					product.getDescription(), product.getImageUrl()));
		}		
		
		return allProductsInList;
		
	}
	
	public List<ProductResponseDTO> getProductPages(UUID userId, int page, int size) {
		
		Pageable pageable = PageRequest.of(page, size);
		Page<Product> pages = this.productRepository.findProductsByUser(userId, pageable);
		return pages.map(product -> new ProductResponseDTO(product.getId(), product.getTitle(), product.getBrand(), product.getDescription(), product.getImageUrl()))
				.stream().toList();
		
	}
	
	public Product editProduct(UUID id, ProductRequestDTO productData) {
		
		Product product = this.productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ERRO - Produto não encontrado."));
		
		if(productData.title() != null)
			product.setTitle(productData.title());
		
		if(productData.brand() != null)
			product.setBrand(productData.brand());
		
		if(productData.description() != null)
			product.setDescription(productData.description());
		
		if(productData.image() != null) 
			product.setImageUrl(this.userService.uploadImage(productData.image()));;
		
		this.productRepository.save(product);
		return product;
		
	}
	
	public Product deleteProduct(UUID productId) {
		
		Product product = this.productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("ERRO - Produto não encontrado."));
		this.productRepository.deleteById(productId);
		return product;
		
	}

}
