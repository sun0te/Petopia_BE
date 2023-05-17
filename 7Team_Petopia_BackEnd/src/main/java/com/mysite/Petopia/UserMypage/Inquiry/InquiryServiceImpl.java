package com.mysite.Petopia.UserMypage.Inquiry;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

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
	public void insertinquiry(InquiryDTO inquiryDTO) {
//		UsersDTO user = new UsersDTO();
//		user.setEmail(username);

		UsersDTO user=new UsersDTO();
		Optional<UsersDTO> userdto=userRepository.findById(inquiryDTO.getUsername());
		if(userdto.isPresent()) {
			user=userdto.get();
		}
		
		inquiryDTO.setUploadDate(LocalDateTime.now());
		inquiryDTO.setUser(user);
		inquiryRepository.save(inquiryDTO);
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
		inquiryDTO.setUploadDate(LocalDateTime.now());
		return inquiryRepository.save(inquiryDTO);
	}

}
