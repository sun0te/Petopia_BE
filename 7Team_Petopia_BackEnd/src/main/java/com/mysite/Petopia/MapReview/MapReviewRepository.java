package com.mysite.Petopia.MapReview;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysite.Petopia.Map.MapDTO;

public interface MapReviewRepository extends JpaRepository<MapReviewDTO, Long> {

	List<MapReviewDTO> findByLocation(MapDTO mapdto);

	List<MapReviewDTO> findByLocationOrderByUpdatedAtDesc(MapDTO mapdto);

	List<MapReviewDTO> findByLocationOrderByRatingDesc(MapDTO mapdto);
	
	List<MapReviewDTO> findByLocationOrderByRatingAsc(MapDTO mapdto);
}
