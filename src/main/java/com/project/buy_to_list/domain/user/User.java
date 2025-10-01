package com.project.buy_to_list.domain.user;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "users")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue
	private UUID id;
	private String name;
	private String username;
	private String email;
	private String password;
	private String imageUrl = null;
	private Date createdAt;
	
	public User() {
		
	}
	
	public User(UUID id, String name, String username, String email, String password, String imageUrl, Date createdAt) {
		
		this.setId(id);
		this.setName(name);
		this.setUsername(username);
		this.setEmail(email);
		this.setPassword(password);
		this.setImageUrl(imageUrl);
		this.setCreatedAt(createdAt);
		
	}
	
	public User(String name, String username, String email, String password, String imageUrl, Date createdAt) {
		
		this.setName(name);
		this.setUsername(username);
		this.setEmail(email);
		this.setPassword(password);
		this.setImageUrl(imageUrl);
		this.setCreatedAt(createdAt);
		
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
}
