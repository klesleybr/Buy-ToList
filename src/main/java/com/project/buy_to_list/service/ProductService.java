package com.project.buy_to_list.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.buy_to_list.domain.product.Product;
import com.project.buy_to_list.domain.product.ProductRequestDTO;
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

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("ERRO - Usuário não encontrado."));
		
		System.out.println(user);
		
		String imageUrl = null;
		if(productData.image() != null) {
			imageUrl = userService.uploadImage(productData.image());
		}
		
		Product product = new Product(productData.title(), productData.brand(), productData.description(), imageUrl, user);
		productRepository.save(product);
		
		return product;
		
	}
	
	public Product editProduct(UUID id, ProductRequestDTO productData) {
		
		Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ERRO - Produto não encontrado."));
		
		if(productData.title() != null)
			product.setTitle(productData.title());
		
		if(productData.brand() != null)
			product.setBrand(productData.brand());
		
		if(productData.description() != null)
			product.setDescription(productData.description());
		
		if(productData.image() != null) 
			product.setImageUrl(userService.uploadImage(productData.image()));;
		
		productRepository.save(product);
		return product;
		
	}
	
	public Product deleteProduct(UUID productId) {
		
		Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("ERRO - Produto não encontrado."));
		productRepository.deleteById(productId);
		return product;
		
	}

}
