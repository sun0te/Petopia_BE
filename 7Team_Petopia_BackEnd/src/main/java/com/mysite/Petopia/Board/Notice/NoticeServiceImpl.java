package com.mysite.Petopia.Board.Notice;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {

	private final NoticeRepository noticeRepository;
	
	public NoticeServiceImpl(NoticeRepository noticeRepository) {
	    this.noticeRepository = noticeRepository;
	}
	
	@Override
	public List<NoticeDTO> getAllNotices() {
		return noticeRepository.findAll();
	}

	@Override
	public NoticeDTO getNoticeById(Long id) {
		return noticeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notice not found with id: " + id));
	}

	@Override
	public void createNotice(NoticeDTO noticeDTO) {
		noticeDTO.setCreatedAt(LocalDateTime.now());
        noticeDTO.setUpdatedAt(LocalDateTime.now());
        noticeRepository.save(noticeDTO);

	}

	@Override
	public void updateNotice(NoticeDTO noticeDTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteNotice(Long id) {
		// TODO Auto-generated method stub

	}

}
