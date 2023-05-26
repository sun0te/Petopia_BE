package com.mysite.Petopia.MapReview;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mysite.Petopia.Board.BoardDTO;
import com.mysite.Petopia.Board.BoardImgDTO;
import com.mysite.Petopia.Map.MapDTO;
import com.mysite.Petopia.Map.MapRepository;
import com.mysite.Petopia.Users.UserRepository;
import com.mysite.Petopia.Users.UsersDTO;

@Service
public class MapReviewServiceImpl implements MapReviewService {

	private MapReviewRepository mapReviewRepository;
	private UserRepository userRepository;
	private MapRepository mapRepository;
	private ReviewImgRepository reviewImgRepository;

	public MapReviewServiceImpl(MapReviewRepository mapReviewRepository, UserRepository userRepository,
			MapRepository mapRepository, ReviewImgRepository reviewImgRepository) {
		this.mapReviewRepository = mapReviewRepository;
		this.userRepository = userRepository;
		this.mapRepository = mapRepository;
		this.reviewImgRepository = reviewImgRepository;
	}

	@Override
	public Long insertReview(MapReviewDTO mapReviewDTO) {

		UsersDTO dto = new UsersDTO();
		MapDTO map = new MapDTO();
		Optional<UsersDTO> userdto = userRepository.findById(mapReviewDTO.getUsername());
		if (userdto.isPresent()) {
			dto = userdto.get();
		}

		Optional<MapDTO> mapdto = mapRepository.findById(mapReviewDTO.getMapid());
		if (mapdto.isPresent()) {
			map = mapdto.get();
		}

		mapReviewDTO.setLocation(map);
		mapReviewDTO.setUpdatedAt(LocalDateTime.now());
		mapReviewDTO.setWriter(dto);
		return mapReviewRepository.save(mapReviewDTO).getId();

	}

	@Override
	public void reviewimgupload(String uploadfiles, Long num) {
		MapReviewDTO mapdto = new MapReviewDTO();
		Optional<MapReviewDTO> reviewdto = mapReviewRepository.findById(num);
		if (reviewdto.isPresent()) {
			mapdto = reviewdto.get();
		}

		ReviewImgDTO dto = new ReviewImgDTO();
		dto.setImageUrl(uploadfiles);
		dto.setReview(mapdto);
		reviewImgRepository.save(dto);
	}

	@Override
	public List<MapReviewDTO> reviewList(Long id) {
		MapDTO map = new MapDTO();
		Optional<MapDTO> mapdto = mapRepository.findById(id);
		if (mapdto.isPresent()) {
			map = mapdto.get();
		}
		return mapReviewRepository.findByLocation(map);
	}

}
