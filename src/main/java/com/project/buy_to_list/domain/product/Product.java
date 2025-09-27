package com.project.buy_to_list.domain.product;

import java.util.UUID;

import com.project.buy_to_list.domain.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "products")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue
	private UUID id;
	private String name;
	private String brand;
	private String description;
	private String imageUrl = null;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

}
