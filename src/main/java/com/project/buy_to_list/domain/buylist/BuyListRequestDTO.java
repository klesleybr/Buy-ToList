package com.project.buy_to_list.domain.buylist;

import java.math.BigDecimal;

public record BuyListRequestDTO(String title, String description, BigDecimal totalValue, Boolean isFinalized) {

}
