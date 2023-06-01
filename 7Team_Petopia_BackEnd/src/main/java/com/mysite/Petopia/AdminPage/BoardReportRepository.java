package com.mysite.Petopia.AdminPage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.mysite.Petopia.AdminPage.BoardReportDTO.ProcessingStatus;

import jakarta.transaction.Transactional;

public interface BoardReportRepository extends JpaRepository<BoardReportDTO, Long>{

	List<BoardReportDTO> findAllByOrderByPostIdAscReportDateDesc();
	
	@Modifying
	@Transactional
	@Query(value="update post_reports set processing_status = :status where id = :id", nativeQuery=true)
	void updateBoardReport(Long id, String status);

	public void deleteByPost_id(Long id);

	void deleteByReporter_email(String email);

	// 게시글 삭제를 위한 리포트 리스트 get
	List<BoardReportDTO> getByReporter_email(String email);

	void deleteAllByReporter_email(String email);

	
}
