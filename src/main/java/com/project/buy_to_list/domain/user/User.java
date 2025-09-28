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
@NoArgsConstructor
@AllArgsConstructor
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
	
	public User(String name, String username, String email, String password, String imageUrl, Date createdAt) {
		
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.imageUrl = imageUrl;
		this.createdAt = createdAt;
		
	}
	
}
