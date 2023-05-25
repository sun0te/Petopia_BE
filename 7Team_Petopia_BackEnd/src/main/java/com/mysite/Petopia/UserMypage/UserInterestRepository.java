package com.mysite.Petopia.UserMypage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterestRepository extends JpaRepository<UserInterestDTO, Long>{
	
	public Boolean existsByPost_idAndUser_email(Long post_id, String user_email);
	
	public void deleteByPost_idAndUser_email(Long post_id, String user_email);

	public void deleteByPost_id(Long id);
}
