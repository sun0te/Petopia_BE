package com.mysite.Petopia.UserMypage.Review;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mysite.Petopia.MapReview.MapReviewDTO;
import com.mysite.Petopia.Users.UserRepository;
import com.mysite.Petopia.Users.UsersDTO;

@Service
public class ReviewServiceImpl implements ReviewService {

	private ReviewRepository reviewRepository;

	private UserRepository userRepository;

	public ReviewServiceImpl(ReviewRepository reviewRepository, UserRepository userRepository) {
		this.reviewRepository = reviewRepository;
		this.userRepository = userRepository;
	}

	@Override
	public void deleteById(List<Long> id) {
		reviewRepository.deleteById(id);
	}

	@Override
	public List<MapReviewDTO> findByWriter(String writer) {
		Optional<UsersDTO> optionaldto = userRepository.findById(writer);
		UsersDTO dto = new UsersDTO();
		if (optionaldto.isPresent()) {
			dto = optionaldto.get();
		}else {
			System.out.println("이메일이 존재하지 않음");
		}
		return reviewRepository.findByWriter(dto);
	}

}
