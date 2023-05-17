package com.mysite.Petopia.UserMypage.Inquiry;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mysite.Petopia.UserMypage.Inquiry.InquiryDTO.InquiryAnswerStatus;
import com.mysite.Petopia.Users.UserRepository;
import com.mysite.Petopia.Users.UsersDTO;

@Service
public class InquiryServiceImpl implements InquiryService {

	private InquiryRepository inquiryRepository;

	private UserRepository userRepository;

	public InquiryServiceImpl(InquiryRepository inquiryRepository, UserRepository userRepository) {
		this.inquiryRepository = inquiryRepository;
		this.userRepository = userRepository;
	}

	@Override
	public void insertinquiry(String title, String content, InquiryAnswerStatus answer_status, String username) {
//		UsersDTO user = new UsersDTO();
//		user.setEmail(username);

		UsersDTO user=new UsersDTO();
		Optional<UsersDTO> userdto=userRepository.findById(username);
		if(userdto.isPresent()) {
			user=userdto.get();
		}
		
		InquiryDTO dto = new InquiryDTO();
		dto.setTitle(title);
		dto.setContent(content);
		dto.setUploadDate(LocalDateTime.now());
		dto.setAnswer_status(answer_status);
		dto.setUsername(username);
		dto.setUser(user);
		inquiryRepository.save(dto);
	}

	@Override
	public List<InquiryDTO> inquirylist(String username) {
		return inquiryRepository.findByUsername(username);
	}

	@Override
	public void inquirydelete(InquiryDTO inquiryDTO) {
		inquiryRepository.delete(inquiryDTO);
	}

	@Override
	public InquiryDTO inquirymodify(InquiryDTO inquiryDTO) {
		inquiryDTO.setId(inquiryDTO.getId());
		inquiryDTO.setTitle(inquiryDTO.getTitle());
		inquiryDTO.setContent(inquiryDTO.getContent());
		inquiryDTO.setUploadDate(LocalDateTime.now());
		inquiryDTO.setAnswer_status(inquiryDTO.getAnswer_status());
		return inquiryRepository.save(inquiryDTO);
	}

}
