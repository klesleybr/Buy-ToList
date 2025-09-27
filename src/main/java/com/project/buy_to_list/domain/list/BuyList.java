package com.project.buy_to_list.domain.list;

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
@NoArgsConstructor
@AllArgsConstructor
public class BuyList {
	
	@Id
	@GeneratedValue
	private UUID id;
	private Date createdAt;
	private String name;
	private String description;
	private BigDecimal totalValue;
	private Boolean isFinalized = false;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	
}
