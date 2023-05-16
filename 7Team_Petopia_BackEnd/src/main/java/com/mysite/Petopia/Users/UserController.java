package com.mysite.Petopia.Users;

import java.sql.Date;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	

	@RequestMapping("/signupkakao")
	public void insertUserKakao(@RequestBody UsersDTO users) {
		System.out.println("email : " + users.getEmail());
		System.out.println("provider : " + users.getProvider());
		System.out.println("password : " + users.getPassword());
		System.out.println("nickname : " + users.getNickname());
		System.out.println("profileImage : " + users.getProfileImage());
		userService.insertUserKakao(users.getEmail(), users.getProvider(), users.getPassword(), users.getNickname(), users.getProfileImage());
		//userService.insertUser2(email, provider, password, name, nickname, birthday, profile, memo);
	}
	
	@RequestMapping("/getUser")
	public UsersDTO getUser(@RequestBody UsersDTO users) {
		System.out.println("email : " + users.getEmail());
		return userService.getUser(users.getEmail());
	}

	
}
