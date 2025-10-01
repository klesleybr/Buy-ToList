package com.project.buy_to_list.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<User> createUser(
				@RequestParam String name,
				@RequestParam String username,
				@RequestParam String email,
				@RequestParam String password,
				@RequestParam(required = false) MultipartFile image
			){
		
		UserRequestDTO body = new UserRequestDTO(name, username, email, password, image, new Date());
		User user = this.userService.createUser(body); 
		return ResponseEntity.ok(user);
	
	}
	
	@PatchMapping(value = "/edit-user", consumes = "multipart/form-data")
	public ResponseEntity<User> editUser(
				@RequestParam UUID id, 
				@RequestParam(required = false) String name,
				@RequestParam(required = false) String username,
				@RequestParam(required = false) String email,
				@RequestParam(required = false) String password,
				@RequestParam(required = false) MultipartFile image
			) {
		
		UserRequestDTO body = new UserRequestDTO(name, username, email, password, image, null);
		User user = this.userService.editUser(id, body);
		return ResponseEntity.ok(user);
		
	}
	
	@DeleteMapping("/delete-user")
	public ResponseEntity<User> deleteUser(@RequestParam UUID id){
		
		User user = userService.deleteUser(id);
		return ResponseEntity.ok(user);
		
	}

}
