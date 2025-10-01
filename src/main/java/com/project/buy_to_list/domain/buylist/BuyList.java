package com.project.buy_to_list.domain.buylist;

import java.math.BigDecimal;
import java.util.Date;
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

@Table(name = "buy_lists")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BuyList {
	
	@Id
	@GeneratedValue
	private UUID id;
	private Date createdAt;
	private String title;
	private String description;
	private BigDecimal totalValue;
	private Boolean isFinalized = false;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public BuyList() {
		
	}
	
	public BuyList(Date createdAt, String title, String description, BigDecimal totalValue, Boolean isFinalized, User user) {
		
		this.createdAt = createdAt;
		this.title = title;
		this.description = description;
		this.totalValue = totalValue;
		this.isFinalized = isFinalized;
		this.user = user;
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getIsFinalized() {
		return isFinalized;
	}

	public void setIsFinalized(Boolean isFinalized) {
		this.isFinalized = isFinalized;
	}

	public BigDecimal getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	
}
