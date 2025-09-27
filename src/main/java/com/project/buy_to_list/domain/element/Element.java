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
@NoArgsConstructor
@AllArgsConstructor
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

}
