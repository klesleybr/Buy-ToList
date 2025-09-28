package com.project.buy_to_list.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.buy_to_list.domain.user.User;
import com.project.buy_to_list.domain.user.UserRequestDTO;
import com.project.buy_to_list.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User createUser(UserRequestDTO userData) {
		
		String imageUrl = null;
		
		if(userData.image() != null) {
			imageUrl = this.uploadImage(userData.image());
		}
		
		User user = new User(userData.name(), userData.username(), userData.email(), userData.password(), imageUrl, userData.createdAt());
		userRepository.save(user);
		return user;
		
	}
	
	protected String uploadImage(MultipartFile image) {
		
		String imageName = UUID.randomUUID() + "-" + image.getOriginalFilename();
		try {
			File file = this.convertMultipartToFile(image);
			// implementação da lógica para subir a imagem para armazenamento e retornar o link de exibição.
			file.delete();
			return "";
		} catch(Exception e) {
			System.out.println("Erro ao tentar fazer o upload da imagem.");
			return null;
		}
		
	}
	
	private File convertMultipartToFile(MultipartFile multipartFile) throws IOException {
		
		File convertedFile = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
		FileOutputStream fileOS = new FileOutputStream(convertedFile);
		fileOS.write(multipartFile.getBytes());
		fileOS.close();
		return convertedFile;
		
	}
	
}
