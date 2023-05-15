package com.mysite.Petopia.Users;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UsersDTO {
	@Id
    @Column(length = 255)
    private String email;

    @Column(length = 10, nullable = false)
    private String provider;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 50)
    private String name;

    @Column(length = 15, nullable = false)
    private String nickname;

    @Column
    private LocalDate birthday;

    @Column(length = 255, nullable = false)
    private String profileImage;

    @Column(name = "joined_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime joinedAt;

    @Column(length = 255)
    private String adminMemo;
}
