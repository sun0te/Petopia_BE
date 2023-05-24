package com.mysite.Petopia.Board;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mysite.Petopia.Board.BoardDTO.BoardCategory;
import com.mysite.Petopia.Board.Travel.TravelRepository;
import com.mysite.Petopia.UserMypage.UserRecommendRepository;
import com.mysite.Petopia.Users.UsersDTO;

import jakarta.transaction.Transactional;

@Service
public class BoardService {

	private BoardRepository repository;
	private BoardImgRepository imgRepository;
	private TravelRepository travelRepository;
	private UserRecommendRepository userRecommendRepositoryl;

	public BoardService(BoardRepository repository, BoardImgRepository imgRepository, TravelRepository travelRepository, UserRecommendRepository userRecommendRepository, UserRecommendRepository userRecommendRepositoryl) {
		this.repository = repository;
		this.imgRepository = imgRepository;
		this.travelRepository = travelRepository;
		this.userRecommendRepositoryl = userRecommendRepositoryl;
	}
	
	// 게시글 작성
	public Long insertBoard(UsersDTO usersDTO, String title, String content, String thumbnailImage, BoardCategory boardCategory) {
		BoardDTO board = new BoardDTO();
		board.setAuthor(usersDTO);
		board.setTitle(title);
		board.setContent(content);
		board.setThumbnailImage(thumbnailImage);
		board.setCategory(boardCategory);
		board.setCreatedAt(LocalDateTime.now());
		board.setUpdatedAt(LocalDateTime.now());
		return repository.save(board).getId();
	}
	
	// 파일 업로드
	public void saveuploadfiles(String uploadfiles, BoardDTO board) {
		BoardImgDTO imgs = new BoardImgDTO();
		imgs.setImageUrl(uploadfiles);
		imgs.setPost(board);
		imgRepository.save(imgs);
	};
	
	// 게시글 상세
	public BoardDTO selectBoard(Long id, BoardCategory boardCategory) {
		repository.updateBoardView(id);
		return repository.findByIdAndCategory(id, boardCategory);
	}
	
	public List<BoardImgDTO> selectBoardImg(Long post_id) {
		return imgRepository.findAllByPost_id(post_id);
	}
	
	@Transactional
	// 게시글 삭제
	public void deleteBoard(Long id) {
		userRecommendRepositoryl.deleteByPost_id(id);
		travelRepository.deleteByPost_id(id);
		imgRepository.deleteByPost_id(id);
		repository.deleteById(id);
	}
	
	// 여행추천 Best
	public List<BoardDTO> selectTravelBoardBest(BoardCategory category) {
		return repository.findTop3ByCategoryOrderByRecommendsDesc(category);
	}
	
	// 여행추천 All
		public List<BoardDTO> selectTravelBoardAll(BoardCategory category) {
			return repository.findByCategoryOrderByCreatedAtDesc(category);
		}
	
}
