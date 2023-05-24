package com.mysite.Petopia.Board.Notice;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface NoticeService {
	List<NoticeDTO> getAllNotices();
    NoticeDTO getNoticeById(Long id);
    void createNotice(NoticeDTO noticeDTO);
    void updateNotice(NoticeDTO noticeDTO);
    void deleteNotice(Long id);
}
