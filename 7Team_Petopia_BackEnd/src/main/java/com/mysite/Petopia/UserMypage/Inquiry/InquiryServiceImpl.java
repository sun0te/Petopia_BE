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

		UsersDTO user = new UsersDTO();
		Optional<UsersDTO> userdto = userRepository.findById(inquiryDTO.getUsername());
		if (userdto.isPresent()) {
			user = userdto.get();
		}

		inquiryDTO.setUploadDate(LocalDateTime.now());
		inquiryDTO.setUser(user);
		inquiryRepository.save(inquiryDTO);
	}

	@Override
	public List<InquiryDTO> inquiryList(String username) {
		return inquiryRepository.findByUsername(username);
	}

	@Override
	public void inquiryDelete(InquiryDTO inquiryDTO) {
		inquiryRepository.delete(inquiryDTO);
	}

	@Override
	public InquiryDTO inquiryModify(InquiryDTO inquiryDTO) {
		inquiryDTO.setUploadDate(LocalDateTime.now());
		return inquiryRepository.save(inquiryDTO);
	}

	@Override
	public List<InquiryDTO> inquiryListAll() {
		return inquiryRepository.findAll();
	}

	@Override
	public InquiryDTO insertAnswer(InquiryDTO inquiryDTO) {
		InquiryDTO dto = new InquiryDTO();
		Optional<InquiryDTO> Optionaldto = inquiryRepository.findById(inquiryDTO.getId());
		if (Optionaldto.isPresent()) {
			dto = Optionaldto.get();
			dto.setAnswer_status(inquiryDTO.getAnswer_status());
			dto.setAnswerContent(inquiryDTO.getAnswerContent());
			dto.setReportDate(LocalDateTime.now());
		} else {
			System.out.println("에러발생");
		}

		return inquiryRepository.save(dto);
	}

	@Override
	public InquiryDTO updateAnswer(InquiryDTO inquiryDTO) {
		InquiryDTO dto = new InquiryDTO();
		Optional<InquiryDTO> Optionaldto = inquiryRepository.findById(inquiryDTO.getId());
		if (Optionaldto.isPresent()) {
			dto = Optionaldto.get();
			dto.setAnswerContent(inquiryDTO.getAnswerContent());
			dto.setReportDate(LocalDateTime.now());
		} else {
			System.out.println("에러발생");
		}

		return inquiryRepository.save(dto);
	}

	@Override
	public InquiryDTO inquiryAnswerDelete(InquiryDTO inquiryDTO) {
		InquiryDTO dto = new InquiryDTO();
		Optional<InquiryDTO> Optionaldto = inquiryRepository.findById(inquiryDTO.getId());
		if (Optionaldto.isPresent()) {
			dto = Optionaldto.get();
			dto.setAnswerContent(null);
			dto.setAnswer_status(inquiryDTO.getAnswer_status());
			dto.setReportDate(null);
		} else {
			System.out.println("에러발생");
		}
		return inquiryRepository.save(dto);
	}

}
