package com.mysite.Petopia.UserMypage.Inquiry;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InquiryController {

	private InquiryServiceImpl inquiryServiceImpl;

	public InquiryController(InquiryServiceImpl inquiryServiceImpl) {
		this.inquiryServiceImpl = inquiryServiceImpl;
	}

	@RequestMapping("/inquirywrite")
	public void insertinquiry(@RequestBody InquiryDTO inquiryDTO) {
		inquiryServiceImpl.insertinquiry(inquiryDTO);
	}
	
	@RequestMapping("/inquirylist")
	public List<InquiryDTO> getinquirylist(@RequestParam String username) {
		return inquiryServiceImpl.inquirylist(username);
	}
	
	@RequestMapping("/inquirydelete")
	public void deleteInquiry(@RequestBody InquiryDTO inquiryDTO) {
		inquiryServiceImpl.inquirydelete(inquiryDTO);
	}
	
	@RequestMapping("/inquiryupdate")
	public InquiryDTO updateInquiry(@RequestBody InquiryDTO inquiryDTO) {
		return inquiryServiceImpl.inquirymodify(inquiryDTO);
	}
	
	
}
