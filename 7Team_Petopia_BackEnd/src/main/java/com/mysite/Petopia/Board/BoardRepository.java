package com.mysite.Petopia.Board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.mysite.Petopia.Board.BoardDTO.BoardCategory;

import jakarta.transaction.Transactional;

public interface BoardRepository extends JpaRepository<BoardDTO, Long>{
	
	public BoardDTO findByIdAndCategory(Long id, BoardCategory category);

	// 조회수 증가
	@Modifying
	@Transactional
	@Query(value="update posts set views = views + 1 where id = :id", nativeQuery=true)
	public void updateBoardView(Long id);
	
	// 게시글 수정
	@Modifying
	@Transactional
	@Query(value="update posts set title = :title, content = :content, updated_at = now() where id = :id", nativeQuery=true)
	public void updateBoard(Long id, String title, String content);
	
	// 여행추천 Best
	public List<BoardDTO> findTop3ByCategoryOrderByRecommendsDesc(BoardCategory category);
	
	// 여행추천 All
	public List<BoardDTO> findByCategoryOrderByCreatedAtDesc(BoardCategory category);

	@Modifying
	@Transactional
	@Query(value="update posts set recommends = recommends + 1 where id = :id", nativeQuery=true)
	public void updateRecommends(Long id);
	
	@Modifying
	@Transactional
	@Query(value="update posts set recommends = recommends - 1 where id = :id", nativeQuery=true)
	public void deleteRecommend(Long id);

	@Modifying
	@Transactional
	@Query(value="update posts set likes = likes + 1 where id = :id", nativeQuery=true)
	public void updateInterest(Long id);

	@Modifying
	@Transactional
	@Query(value="update posts set likes = likes - 1 where id = :id", nativeQuery=true)
	public void deleteInterest(Long id);

}
