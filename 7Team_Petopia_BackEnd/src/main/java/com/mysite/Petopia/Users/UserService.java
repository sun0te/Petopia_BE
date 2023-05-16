package com.mysite.Petopia.Users;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	private UserRepository repository;
	
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	

	
	public void insertUserKakao(String email, String provider, String password, String nickname, String profileImage) {
		repository.insertUserKakao(email, provider, password, nickname, profileImage);

	}

	

	public UsersDTO getUser(String email) {
		return repository.findById(email).orElse(null);
	}

	
}
