package com.mysite.Petopia.Board.Notice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "notice_images")
public class NoticeImageDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "notice_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_notice_image_id"))
    private NoticeDTO post;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    // 추가: Lombok의 @Getter와 @Setter를 사용하여 getter와 setter 메서드 자동 생성
    public NoticeDTO getPost() {
        return post;
    }

    public void setPost(NoticeDTO post) {
        this.post = post;
    }
}

