package com.mysite.Petopia.AdminPage;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mysite.Petopia.AdminPage.BoardReportDTO.ProcessingStatus;
import com.mysite.Petopia.AdminPage.BoardReportDTO.ReportReason;
import com.mysite.Petopia.Board.BoardDTO;
import com.mysite.Petopia.Users.UsersDTO;

@Service
public class BoardReportService {

	private BoardReportRepository repository;

	public BoardReportService(BoardReportRepository repository) {
		this.repository = repository;
	}

	public void insertBoardReport(BoardDTO board, UsersDTO user, ReportReason reportReason, String otherReason,
			ProcessingStatus status) {
		BoardReportDTO boardReportDTO = new BoardReportDTO();
		boardReportDTO.setBoard(board);
		boardReportDTO.setReportDate(LocalDateTime.now());
		boardReportDTO.setReporter(user);
		boardReportDTO.setReason(reportReason);
		boardReportDTO.setOtherReason(otherReason);
		boardReportDTO.setProcessingStatus(status);
		repository.save(boardReportDTO);
	}

	public List<BoardReportDTO> selectBoardReportlist() {
		return repository.findAllByOrderByReportDate();
	}
	
	public void updateBoardReport(Long id, ProcessingStatus status) {
		String temp = status.toString();
		repository.updateBoardReport(id, temp);
	}
}
