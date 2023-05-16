package com.mysite.Petopia.Map;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MapServiceImpl implements MapService {

	private MapRepository mapRepository;

	public MapServiceImpl(MapRepository mapRepository) {
		this.mapRepository = mapRepository;
	}

	@Override
	public List<MapDTO> getmaplist() {
		return mapRepository.findAll();
	}

	@Override
	public MapDTO findByLatAndLng(Double lat, Double lng) {
		return mapRepository.findByLatAndLng(lat, lng);
	}

}
