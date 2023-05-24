package com.mysite.Petopia.Board;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "post_images")
public class BoardImgDTO {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_post_images_post_id"))
    private BoardDTO post;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;
}
