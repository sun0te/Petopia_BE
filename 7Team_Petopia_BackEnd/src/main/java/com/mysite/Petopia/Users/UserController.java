package com.mysite.Petopia.Users;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.Petopia.AdminPage.BoardReportDTO;
import com.mysite.Petopia.AdminPage.BoardReportService;
import com.mysite.Petopia.Board.BoardDTO;
import com.mysite.Petopia.Board.BoardService;
import com.mysite.Petopia.UserMypage.UserInterestDTO;
import com.mysite.Petopia.UserMypage.UserInterestService;
import com.mysite.Petopia.UserMypage.UserRecommendDTO;
import com.mysite.Petopia.UserMypage.UserRecommendService;

import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	private BoardService boardService;
	private BoardReportService boardReportService;
	private UserInterestService userInterestService;
	private UserRecommendService userRecommendService;

	public UserController(UserService userService, BoardService boardService, BoardReportService boardReportService,
			UserInterestService userInterestService, UserRecommendService userRecommendService) {
		super();
		this.userService = userService;
		this.boardService = boardService;
		this.boardReportService = boardReportService;
		this.userInterestService = userInterestService;
		this.userRecommendService = userRecommendService;
	}
	
	@RequestMapping("/signuppetopia")
	public void insertUserPetopia(@RequestBody UsersDTO users) {
		userService.insertUserPetopia(users.getEmail(), users.getProvider(), users.getPassword(), users.getName(), users.getNickname(), users.getBirthday(), users.getProfileImage());

	}
	
	@RequestMapping("/signupkakao")
	public void insertUserKakao(@RequestBody UsersDTO users) {
		userService.insertUserKakao(users.getEmail(), users.getProvider(), users.getPassword(), users.getNickname(), users.getProfileImage());
	}
	
	@RequestMapping("/signupnaver")
	public void insertUserNaver(@RequestBody UsersDTO users) {
		userService.insertUserNaver(users.getEmail(), users.getProvider(), users.getPassword(), users.getName(), users.getNickname(), users.getProfileImage());
	}
	
	@RequestMapping("/getuserpetopia")
	public UsersDTO getUser(@RequestBody UsersDTO users) {
		return userService.getUserPetopia(users.getEmail(), users.getPassword());
	}
	
	@RequestMapping("/getuserinfo")
	public UsersDTO getUserInfo(@RequestBody UsersDTO users) {
		return userService.getUserInfo(users.getEmail());
	}

	@RequestMapping("/findemail")
	public List<UsersDTO> findUserEmail(@RequestBody UsersDTO users) {
		return userService.findUserEmail(users.getName(), users.getPassword(), users.getBirthday());
	}
	
	@RequestMapping("/findpassword")
	public UsersDTO findUserPassword(@RequestBody UsersDTO users) {
		return userService.findUserPassword(users.getEmail(), users.getName(), users.getBirthday());
	}
	
	@RequestMapping("/updateuserinfo")
	public void updateUserInfo(@RequestBody UsersDTO users) {
		userService.updateUserInfo(users.getEmail(), users.getName(), users.getNickname(), users.getPassword());
	}
	
	// 계정 삭제
	@Transactional
	@RequestMapping("/withdrawal")
	public void deleteUserInfo(@RequestBody UsersDTO users) {
		// 작성한 게시글 리스트
		List<BoardDTO> boardDTOList = boardService.getByAuthor_email(users.getEmail());
		for(BoardDTO boardDTO: boardDTOList) {
			
			// 작성한 게시글당 신고 리스트
			List<BoardReportDTO> boardReportDTOList = boardReportService.getByReporter_email(boardDTO.getAuthor().getEmail());
			for(BoardReportDTO boardReportDTO: boardReportDTOList) {
				boardReportService.deleteByEmail(boardReportDTO.getReporter().getEmail());
			}
			boardService.deleteBoard(boardDTO.getId());
		}
		
		String user_email = users.getEmail();
		// 계정이 report 한 게시글의 신고 숫자 감소 로직 + report 데이터 삭제
		List<BoardReportDTO> boardReportDTOList = boardReportService.getByReporter_email(user_email);
		for(BoardReportDTO boardReportDTO: boardReportDTOList) {
			boardService.deleteReportBoard(boardReportDTO.getPost().getId());
		}
		boardReportService.deleteAllByReporter_email(users.getEmail());
		
		// 계정이 recommend 한 게시글의 추천 숫자 감소 로직 + recommend 데이터 삭제
		List<UserRecommendDTO> userRecommendDTOList = userRecommendService.findAllByUser_email(user_email);
		for(UserRecommendDTO recommend: userRecommendDTOList) {
			boardService.deleteRecommend(recommend.getPost().getId());
		}
		userRecommendService.deleteAllByUser_email(users.getEmail());
		
		// 계정이 interest 한 게시글의 좋아요 숫자 감소 로직 + interest 데이터 삭제
		List<UserInterestDTO> userInterestDTOList = userInterestService.findAllByUser_email(user_email);
		for(UserInterestDTO interest: userInterestDTOList) {
			boardService.deleteInterest(interest.getPost().getId());
		}
		userInterestService.deleteByUser_email(user_email);
		
		userService.deleteUserInfo(users.getEmail());
	}
	
}
