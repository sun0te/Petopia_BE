package com.mysite.Petopia.AdminPage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.mysite.Petopia.AdminPage.BoardReportDTO.ProcessingStatus;

import jakarta.transaction.Transactional;

public interface BoardReportRepository extends JpaRepository<BoardReportDTO, Long>{

	List<BoardReportDTO> findAllByOrderByReportDateDesc();

	@Modifying
	@Transactional
	@Query(value="update post_reports set processing_status = :status where id = :id", nativeQuery=true)
	void updateBoardReport(Long id, String status);

	public void deleteByPost_id(Long id);
}
