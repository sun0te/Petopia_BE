package com.mysite.Petopia.UserMypage.Inquiry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository extends JpaRepository<InquiryDTO, Long> {

	List<InquiryDTO> findByUsername(String username);

}
