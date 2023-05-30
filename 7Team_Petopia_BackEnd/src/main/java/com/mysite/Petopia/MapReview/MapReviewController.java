package com.mysite.Petopia.MapReview;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mysite.Petopia.Board.BoardDTO;
import com.mysite.Petopia.Board.BoardService;

@RestController
@RequestMapping("/review")
public class MapReviewController {

	private MapReviewService reviewservice;

	public MapReviewController(MapReviewService reviewservice) {
		super();
		this.reviewservice = reviewservice;
	}

	Long reviewid;

	// 리뷰 작성
	@RequestMapping("/write")
	public Long insertReview(@RequestBody MapReviewDTO reviewDTO) {
		reviewid = reviewservice.insertReview(reviewDTO.getWriter(),
				reviewDTO.getRating(), reviewDTO.getContent(), reviewDTO.getCost(),
				reviewDTO.getLocation(), reviewDTO.getPriceType(), reviewDTO.getPriceLevel());
		return reviewid;
	}

	// 파일 업로드
	@RequestMapping("/uploadfiles")
	public void uploadfiles(@RequestBody MultipartFile[] uploadfiles) throws IOException {
		for (MultipartFile file : uploadfiles) {
			if (!file.isEmpty()) {
				File storedFilename = new File(UUID.randomUUID().toString().replaceAll("-", "") + ".jpg");
				file.transferTo(storedFilename);
				MapReviewDTO reviewDTO = new MapReviewDTO();
				reviewDTO.setId(reviewid);
				reviewservice.saveuploadfiles(storedFilename.toString(), reviewDTO);
			}
		}
	}

}
