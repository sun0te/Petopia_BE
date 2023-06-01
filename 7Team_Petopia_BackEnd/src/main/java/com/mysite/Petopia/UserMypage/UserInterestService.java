package com.mysite.Petopia.UserMypage;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mysite.Petopia.Board.BoardDTO;
import com.mysite.Petopia.Board.BoardRepository;
import com.mysite.Petopia.Users.UsersDTO;

import jakarta.transaction.Transactional;

@Service
public class UserInterestService {

	private UserInterestRepository repository;
	private BoardRepository boardRepository;
	
	public UserInterestService(UserInterestRepository repository, BoardRepository boardRepository) {
		this.repository = repository;
		this.boardRepository = boardRepository;
	}
	
	// 검사
	public Boolean selectInterest(Long post_id, String user_email) {
		return repository.existsByPost_idAndUser_email(Long.valueOf(post_id), user_email);
	}
	// 추천
	public void insertInterest(BoardDTO post_id, UsersDTO user_email) {
		UserInterestDTO InterestDTO = new UserInterestDTO();
		InterestDTO.setPost(post_id);
		InterestDTO.setUser(user_email);
		InterestDTO.setClickedAt(LocalDateTime.now());
		boardRepository.updateInterest(post_id.getId());
		repository.save(InterestDTO);
	}
	// 해제
	@Transactional
	public void deleteInterest(BoardDTO post_id, UsersDTO user_email) {
		boardRepository.deleteInterest(post_id.getId());
		repository.deleteByPost_idAndUser_email(post_id.getId(), user_email.getEmail());
	}

	@Transactional
	public int deleteByUser_email(String user_email) {
		return repository.deleteByUser_email(user_email);
		
	}

	public List<UserInterestDTO> findAllByUser_email(String user_email) {
		return repository.findAllByUser_email(user_email);
	}

}
