package com.project.buy_to_list.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.buy_to_list.domain.user.User;
import com.project.buy_to_list.domain.user.UserRequestDTO;
import com.project.buy_to_list.service.UserService;

@RestController
@RequestMapping("/buy-tolist/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/create-user", consumes = "multipart/form-data")
	public ResponseEntity<User> create(
				@RequestParam("name") String name,
				@RequestParam("username") String username,
				@RequestParam("email") String email,
				@RequestParam("password") String password,
				@RequestParam(value = "image", required = false) MultipartFile image
			){
		
		UserRequestDTO body = new UserRequestDTO(name, username, email, password, image, new Date());
		User user = this.userService.createUser(body); 
		return ResponseEntity.ok(user);
	
	}

}
