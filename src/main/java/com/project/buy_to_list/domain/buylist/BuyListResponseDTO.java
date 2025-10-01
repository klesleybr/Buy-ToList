package com.project.buy_to_list.domain.buylist;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public record BuyListResponseDTO(UUID id, Date createdAt, String title, String description, BigDecimal totalValue, Boolean isFinalized) {

}