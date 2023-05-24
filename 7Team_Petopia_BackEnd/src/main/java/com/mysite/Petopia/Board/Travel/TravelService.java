package com.mysite.Petopia.Board.Travel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.mysite.Petopia.Board.BoardDTO;
import com.mysite.Petopia.Board.Travel.TravelBoardDTO.Category;


@Service
public class TravelService {

	private TravelRepository repository;

	public TravelService(TravelRepository repository) {
		this.repository = repository;
	}

//	public Integer insertTravelBoard(UsersDTO usersDTO, String title, String content, String thumbnailImage, BoardCategory boardCategory) {
//		String boardcategory = boardCategory.toString();
//		repository.insertTravelBoard(usersDTO.getEmail(), title, content, thumbnailImage, boardcategory);
//		 TravelBoardDTO travelBoardDTO = new TravelBoardDTO();
//	        TravelBoardDTO savedBoardDTO = repository.save(travelBoardDTO);
//	        return savedBoardDTO.getId();
//	}

	public void insertTravelBoardInfo(BoardDTO boardDTO, String placename, Category category,
			String petProvisions) {
		TravelBoardDTO travelboard = new TravelBoardDTO();
		travelboard.setPost(boardDTO);
		travelboard.setPlaceName(placename);
		travelboard.setCategory(category);
		travelboard.setPetProvisions(petProvisions);
		repository.save(travelboard);
	}
	
	public TravelBoardDTO selectTravelBoardInfo(Long post_id) {
		return repository.findByPost_id(Long.valueOf(post_id));
	}
}
