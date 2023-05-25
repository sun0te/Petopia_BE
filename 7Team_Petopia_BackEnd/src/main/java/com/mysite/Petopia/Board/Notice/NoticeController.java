package com.mysite.Petopia.Board.Notice;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notice")
public class NoticeController {
	private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping
    public List<NoticeDTO> getAllNotices() {
        return noticeService.getAllNotices();
    }

    @GetMapping("/{id}")
    public NoticeDTO getNoticeById(@PathVariable Long id) {
        return noticeService.getNoticeById(id);
    }

    @PostMapping
    public void createNotice(@RequestBody NoticeDTO noticeDTO) {
        noticeService.createNotice(noticeDTO);
    }

}
