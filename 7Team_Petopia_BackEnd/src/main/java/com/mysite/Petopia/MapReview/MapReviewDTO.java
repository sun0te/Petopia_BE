package com.mysite.Petopia.MapReview;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.mysite.Petopia.Map.MapDTO;
import com.mysite.Petopia.Users.UsersDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "reviews")
public class MapReviewDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "writer_email", referencedColumnName = "email", foreignKey = @ForeignKey(name = "FK_reviews_writer_email"))
    private UsersDTO writer;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "content")
    private String content;

    @Column(name = "cost", nullable = false)
    private int cost;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_reviews_location_id"))
    private MapDTO location;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "price_type", nullable = false)
    private PriceType priceType;

    @Enumerated(EnumType.STRING)
    @Column(name = "price_level", nullable = false)
    private PriceLevel priceLevel;

    public enum PriceType {
        HOSPITAL,
        FOOD_CAFE,
        ACCOMMODATION,
        ETC
    }

    public enum PriceLevel {
        CHEAP,
        MODERATE,
        EXPENSIVE
    }
}