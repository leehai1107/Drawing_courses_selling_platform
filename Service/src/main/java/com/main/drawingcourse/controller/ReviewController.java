package com.main.drawingcourse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.drawingcourse.dto.ResponseReview;
import com.main.drawingcourse.dto.ReviewModel;
import com.main.drawingcourse.repository.ReviewRepositoty;
import com.main.drawingcourse.service.IReviewService;

@RestController
@RequestMapping("public/review")
public class ReviewController {
	@Autowired
	IReviewService iReviewService;

	@Autowired
	ReviewRepositoty reviewRepositoty;

	@PostMapping(value = "/add")
	public ResponseReview AddFeedBack(@RequestBody ReviewModel reviewModel) {
		return iReviewService.addFeedBack(reviewModel);
	}

	@GetMapping(value = "/find-All-FeedBacks-By-UserId/{id}")
	public List<ReviewModel> findAllFeedBacksByUserId(@PathVariable int id) {
		return iReviewService.findAllFeedBackByUserId(id);
	}

	@GetMapping(value = "/find-All-FeedBacks-By-Course/{id}")
	public List<ReviewModel> findAllFeedBacksByCourse(@PathVariable int id) {
		return iReviewService.findAllFeedBackByCourse(id);
	}
}
