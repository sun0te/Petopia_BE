package com.mysite.Petopia.Users;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

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
	
	@RequestMapping("/signuppetopia")
	public void insertUserPetopia(@RequestBody UsersDTO users) {
//		System.out.println("email : " + users.getEmail());
//		System.out.println("provider : " + users.getProvider());
//		System.out.println("password : " + users.getPassword());
//		System.out.println("name : " + users.getName());
//		System.out.println("nickname : " + users.getNickname());
//		System.out.println("birthday : " + users.getBirthday());
//		System.out.println("profileImage : " + users.getProfileImage());
		userService.insertUserPetopia(users.getEmail(), users.getProvider(), users.getPassword(), users.getName(), users.getNickname(), users.getBirthday(), users.getProfileImage());

	}
	
	@RequestMapping("/signupkakao")
	public void insertUserKakao(@RequestBody UsersDTO users) {
		userService.insertUserKakao(users.getEmail(), users.getProvider(), users.getPassword(), users.getNickname(), users.getProfileImage());
	}
	
	@RequestMapping("/signupnaver")
	public void insertUserNaver(@RequestBody UsersDTO users) {
		userService.insertUserNaver(users.getEmail(), users.getProvider(), users.getPassword(), users.getName(), users.getNickname(), users.getProfileImage());
	}
	
	@RequestMapping("/getuserpetopia")
	public UsersDTO getUser(@RequestBody UsersDTO users) {
		return userService.getUserPetopia(users.getEmail(), users.getPassword());
	}
	
	@RequestMapping("/getuserinfo")
	public UsersDTO getUserInfo(@RequestBody UsersDTO users) {
		return userService.getUserInfo(users.getEmail());
	}

	@RequestMapping("/findemail")
	public List<UsersDTO> findUserEmail(@RequestBody UsersDTO users) {
		return userService.findUserEmail(users.getName(), users.getPassword(), users.getBirthday());
	}
	
	@RequestMapping("/findpassword")
	public UsersDTO findUserPassword(@RequestBody UsersDTO users) {
		return userService.findUserPassword(users.getEmail(), users.getName(), users.getBirthday());
	}
	
	@RequestMapping("/updateuserinfo")
	public void updateUserInfo(@RequestBody UsersDTO users) {
		userService.updateUserInfo(users.getEmail(), users.getName(), users.getNickname(), users.getPassword());
	}
	
	
}
