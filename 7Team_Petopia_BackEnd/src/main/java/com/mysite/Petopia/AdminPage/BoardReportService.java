package com.mysite.Petopia.AdminPage;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mysite.Petopia.AdminPage.BoardReportDTO.ProcessingStatus;
import com.mysite.Petopia.AdminPage.BoardReportDTO.ReportReason;
import com.mysite.Petopia.Board.BoardDTO;
import com.mysite.Petopia.Board.BoardRepository;

import com.mysite.Petopia.MapReview.MapReviewDTO;
import com.mysite.Petopia.MapReview.MapReviewRepository;

import com.mysite.Petopia.Users.UsersDTO;

@Service
public class BoardReportService {

	private BoardReportRepository repository;
	private BoardRepository boardRepository;

	private MapReviewRepository mapReviewRepository;

	public BoardReportService(BoardReportRepository repository, BoardRepository boardRepository,
			MapReviewRepository mapReviewRepository) {
		this.repository = repository;
		this.boardRepository = boardRepository;
		this.mapReviewRepository = mapReviewRepository;
	}

	public void insertBoardReport(BoardDTO board, UsersDTO user, ReportReason reportReason, String otherReason,
			ProcessingStatus status) {
		BoardReportDTO boardReportDTO = new BoardReportDTO();
		boardReportDTO.setPost(board);
		boardReportDTO.setReportDate(LocalDateTime.now());
		boardReportDTO.setReporter(user);
		boardReportDTO.setReason(reportReason);
		boardReportDTO.setOtherReason(otherReason);
		boardReportDTO.setProcessingStatus(status);
		repository.save(boardReportDTO);
		boardRepository.reportBoard(board.getId());
	}

	public void insertReviewReport(MapReviewDTO review, UsersDTO user, ReportReason reportReason, String otherReason,
			ProcessingStatus status) {
		BoardReportDTO boardReportDTO = new BoardReportDTO();
		boardReportDTO.setReview(review);
		boardReportDTO.setReportDate(LocalDateTime.now());
		boardReportDTO.setReporter(user);
		boardReportDTO.setReason(reportReason);
		boardReportDTO.setOtherReason(otherReason);
		boardReportDTO.setProcessingStatus(status);
		repository.save(boardReportDTO);
		mapReviewRepository.reportReview(review.getId());
	}

	public List<BoardReportDTO> selectBoardReportlist() {
		return repository.findAllByOrderByPostIdAscReportDateDesc();
	}

	public void updateBoardReport(Long id, ProcessingStatus status) {
		String temp = status.toString();
		repository.updateBoardReport(id, temp);
	}
}
