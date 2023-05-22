package com.mysite.Petopia.UserMypage.Inquiry;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface InquiryRepository extends JpaRepository<InquiryDTO, Long> {

	List<InquiryDTO> findByUsername(String username);

}
