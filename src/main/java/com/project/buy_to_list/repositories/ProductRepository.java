package com.project.buy_to_list.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.buy_to_list.domain.product.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {
	
	@Query("SELECT p FROM Product AS p WHERE user.id = :userId")
	public List<Product> findProductsByUser(@Param("userId") UUID userId);
	
	@Query("SELECT p FROM Product AS p WHERE user.id = :userId")
	public Page<Product> findProductsByUser(@Param("userId") UUID userId, Pageable pageable);

}
