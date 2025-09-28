package com.project.buy_to_list.domain.user;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public record UserRequestDTO(String name, String username, String email, String password, MultipartFile image, Date createdAt) {

}
