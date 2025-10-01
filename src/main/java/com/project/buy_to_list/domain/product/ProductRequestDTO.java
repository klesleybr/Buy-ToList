package com.project.buy_to_list.domain.product;

import org.springframework.web.multipart.MultipartFile;

public record ProductRequestDTO(String title, String brand, String description, MultipartFile image) {

}
