package com.mysite.Petopia.UserMypage.Inquiry;

import java.util.List;

import com.mysite.Petopia.UserMypage.Inquiry.InquiryDTO.InquiryAnswerStatus;

public interface InquiryService {
	void insertinquiry(String title, String content,InquiryAnswerStatus answer_status,String username);
	List<InquiryDTO> inquirylist(String username);
	public void inquirydelete(InquiryDTO inquiryDTO);
	public InquiryDTO inquirymodify(InquiryDTO inquiryDTO);
}
