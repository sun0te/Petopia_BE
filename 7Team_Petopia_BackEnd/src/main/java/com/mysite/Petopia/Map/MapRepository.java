package com.mysite.Petopia.Map;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MapRepository extends JpaRepository<MapDTO, Long> {

	public MapDTO findByLatAndLng(Double lat, Double lng);
	
}
