package com.project.buy_to_list.domain.product;

import java.util.UUID;

public record ProductResponseDTO(UUID id, String title, String brand, String description, String imageUrl) {

}
