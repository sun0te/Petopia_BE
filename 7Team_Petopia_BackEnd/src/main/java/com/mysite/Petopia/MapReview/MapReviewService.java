package com.mysite.Petopia.MapReview;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.mysite.Petopia.Map.MapDTO;
import com.mysite.Petopia.MapReview.MapReviewDTO.PriceLevel;
import com.mysite.Petopia.MapReview.MapReviewDTO.PriceType;
import com.mysite.Petopia.Users.UsersDTO;

@Service
public class MapReviewService {

	private MapReviewRepository repository;
	private ReviewImgRepository reviewImgRepository;
	
	public MapReviewService(MapReviewRepository repository, ReviewImgRepository reviewImgRepository) {
		this.repository = repository;
		this.reviewImgRepository = reviewImgRepository;
	}
	
	public Long insertReview(UsersDTO usersDTO, int rating, String content, int cost, MapDTO location, PriceType priceType, PriceLevel priceLevel) {
		MapReviewDTO reviewDTO = new MapReviewDTO();
		reviewDTO.setWriter(usersDTO);
		reviewDTO.setRating(rating);
		reviewDTO.setContent(content);
		reviewDTO.setCost(cost);
		reviewDTO.setLocation(location);
		reviewDTO.setPriceType(priceType);
		reviewDTO.setPriceLevel(priceLevel);
		reviewDTO.setUpdatedAt(LocalDateTime.now());
		return repository.save(reviewDTO).getId();
	}
	
	// 파일 업로드
	public void saveuploadfiles(String uploadfiles, MapReviewDTO reviewDTO) {
		ReviewImgDTO imgs = new ReviewImgDTO();
		imgs.setImageUrl(uploadfiles);
		imgs.setReview(reviewDTO);
		reviewImgRepository.save(imgs);
	};
}
