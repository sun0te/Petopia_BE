package com.mysite.Petopia.UserMypage.Inquiry;

import java.time.LocalDateTime;

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
@Table(name = "inquiries")
public class InquiryDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_email", referencedColumnName = "email", foreignKey = @ForeignKey(name = "FK_inquiries_user_email"))
	private UsersDTO user;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "content", nullable = false)
	private String content;
	
	@Column(name = "answer_content")
	private String answerContent;

	@Column(name = "upload_date", nullable = false)
	private LocalDateTime uploadDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "answer_status", nullable = false)
	private InquiryAnswerStatus answer_status;

	@Column(name = "report_date")
	private LocalDateTime reportDate;

	@Column(name = "username")
	private String username;

	public enum InquiryAnswerStatus {
		PENDING, ANSWERED
	}

}
