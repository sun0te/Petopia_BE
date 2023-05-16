package com.mysite.Petopia.Users;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<UsersDTO, String> {

	@Modifying
	@Transactional
	@Query(value="insert into users(email, provider, password, nickname, profileImage) values(:email, :provider, :password, :nickname, :profileImage)", nativeQuery=true)
	void insertUserKakao(String email, String provider, String password, String nickname, String profileImage);
	

	
}
