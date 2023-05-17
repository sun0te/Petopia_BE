package com.mysite.Petopia.UserMypage.Inquiry;

import java.util.List;

public interface InquiryService {
	void insertinquiry(InquiryDTO inquiryDTO);
	List<InquiryDTO> inquirylist(String username);
	public void inquirydelete(InquiryDTO inquiryDTO);
	public InquiryDTO inquirymodify(InquiryDTO inquiryDTO);
}
