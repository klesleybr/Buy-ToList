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
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue
	private UUID id;
	private String title;
	private String brand;
	private String description;
	private String imageUrl = null;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Product() {
		
	}
	
	public Product(String title, String brand, String description, String imageUrl, User user) {
		
		this.setTitle(title);
		this.setBrand(brand);
		this.setDescription(description);
		this.setImageUrl(imageUrl);
		this.setUser(user);
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

}
