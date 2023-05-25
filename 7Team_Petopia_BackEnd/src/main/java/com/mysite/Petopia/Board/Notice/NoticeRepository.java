package com.mysite.Petopia.Board.Notice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<NoticeDTO, Long> {
    
}