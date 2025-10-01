package com.project.buy_to_list.domain.element;

import java.math.BigDecimal;
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

@Table(name = "elements")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Element {
	
	@Id
	@GeneratedValue
	private UUID id;
	private UUID productId;
	private UUID buyListId;
	private Date dateAdd;
	private int amount;
	private BigDecimal price;
	private Boolean isWeightSell = false;
	private float weight;
	private Boolean wasBought = false;
	
	public Element() {
		
	}

	public Boolean getWasBought() {
		return wasBought;
	}

	public void setWasBought(Boolean wasBought) {
		this.wasBought = wasBought;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public Boolean getIsWeightSell() {
		return isWeightSell;
	}

	public void setIsWeightSell(Boolean isWeightSell) {
		this.isWeightSell = isWeightSell;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDateAdd() {
		return dateAdd;
	}

	public void setDateAdd(Date dateAdd) {
		this.dateAdd = dateAdd;
	}

	public UUID getBuyListId() {
		return buyListId;
	}

	public void setBuyListId(UUID buyListId) {
		this.buyListId = buyListId;
	}

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

}
