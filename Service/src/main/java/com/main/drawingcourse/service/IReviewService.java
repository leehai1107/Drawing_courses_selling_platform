package com.main.drawingcourse.service;

import com.main.drawingcourse.dto.ResponseReview;
import com.main.drawingcourse.dto.ReviewModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IReviewService {
    ResponseReview addFeedBack(ReviewModel reviewModel);
    List<ReviewModel>findAllFeedBackByUserId(int id);

    List<ReviewModel>findAllFeedBackByCourse(int id);


}
