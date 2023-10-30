package com.main.drawingcourse.service;

import java.util.List;

import com.main.drawingcourse.dto.ResponseReview;
import com.main.drawingcourse.dto.ReviewModel;

public interface IReviewService {
	ResponseReview addFeedBack(ReviewModel reviewModel);

	List<ReviewModel> findAllFeedBackByUserId(int id);

	List<ReviewModel> findAllFeedBackByCourse(int id);

}
