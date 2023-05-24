package com.mysite.Petopia.Board.Travel;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/travel")
public class TravelController {

	private TravelService travelService;

	public TravelController(TravelService travelService) {
		super();
		this.travelService = travelService;
	}

	
//	@RequestMapping("/write")
//	public Integer insertTravelBoard(@RequestBody BoardDTO board) {
//		return travelService.insertTravelBoard(board.getAuthor(), board.getTitle(), board.getContent(), board.getThumbnailImage(), board.getCategory());
//	}

	@PostMapping("/writeinfo")
    public void insertTravelBoardInfo(@RequestBody TravelBoardDTO travelDTO) {
        travelService.insertTravelBoardInfo(travelDTO.getPost(), travelDTO.getPlaceName(),
               travelDTO.getCategory(), travelDTO.getPetProvisions());
    }
	
	@PostMapping("/getinfo")
    public TravelBoardDTO selectTravelBoardInfo(@RequestBody TravelBoardDTO travelDTO) {
        return travelService.selectTravelBoardInfo(travelDTO.getPost().getId());
    }
	
}
