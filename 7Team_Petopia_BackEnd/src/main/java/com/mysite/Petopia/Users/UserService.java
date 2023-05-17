package com.mysite.Petopia.Users;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	private UserRepository repository;
	
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	public void insertUserPetopia(String email, String provider, String password, String name, String nickname, LocalDate birthday, String profileImage) {
		repository.insertUserPetopia(email, provider, password, name, nickname, birthday, profileImage);

	}
	
	public void insertUserKakao(String email, String provider, String password, String nickname, String profileImage) {
		repository.insertUserKakao(email, provider, password, nickname, profileImage);

	}

	public void insertUserNaver(String email, String provider, String password, String name, String nickname, String profileImage) {
		repository.insertUserNaver(email, provider, password, name, nickname, profileImage);

	}

	public UsersDTO getUserPetopia(String email, String password) {
		return repository.findByEmailAndPassword(email, password);
	}
	
	public UsersDTO getUserInfo(String email) {
		return repository.findById(email).orElse(null);
	}

	public List<UsersDTO> findUserEmail(String name, String password, LocalDate birthday) {
		return repository.findByNameAndPasswordAndBirthday(name, password, birthday);
	}
	
}
