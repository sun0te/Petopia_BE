package com.mysite.Petopia.AdminPage;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mysite.Petopia.AdminPage.BoardReportDTO.ProcessingStatus;
import com.mysite.Petopia.AdminPage.BoardReportDTO.ReportReason;
import com.mysite.Petopia.Board.BoardDTO;
import com.mysite.Petopia.Board.BoardRepository;
import com.mysite.Petopia.Users.UsersDTO;

@Service
public class BoardReportService {

	private BoardReportRepository repository;
	private BoardRepository boardRepository;

	public BoardReportService(BoardReportRepository repository, BoardRepository boardRepository) {
		this.repository = repository;
		this.boardRepository = boardRepository;
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

	public List<BoardReportDTO> selectBoardReportlist() {
		return repository.findAllByOrderByPostIdAscReportDateDesc();
	}
	
	public void updateBoardReport(Long id, ProcessingStatus status) {
		String temp = status.toString();
		repository.updateBoardReport(id, temp);
	}
	
	//삭제를 위한 리포트 리스트 get
	public List<BoardReportDTO> getByReporter_email(String email) {
		return repository.getByReporter_email(email);
	}

	// 해당 계정이 리포트한 데이터 삭제
	public void deleteByEmail(String email) {
		
	}

	public void deleteAllByReporter_email(String email) {
		repository.deleteAllByReporter_email(email);
		
	}
}
