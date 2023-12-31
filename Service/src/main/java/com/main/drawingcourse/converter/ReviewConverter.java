package com.main.drawingcourse.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.main.drawingcourse.dto.ResponseReview;
import com.main.drawingcourse.dto.ReviewModel;
import com.main.drawingcourse.entity.Review;
import com.main.drawingcourse.repository.Course_OrderRepository;
import com.main.drawingcourse.repository.ReviewRepositoty;

@Component
public class ReviewConverter {

	@Autowired
	CourseConverter courseConverter;

	@Autowired
	ReviewRepositoty reviewRepositoty;
	@Autowired
	Course_OrderRepository courseOrderRepository;
	@Autowired
	Course_OrderConverter courseOrderConverter;
	@Autowired
	OrderConverter orderConverter;

	public Review toEntity(ReviewModel reviewModel) {
		Review entity = new Review();
		entity.setReviewId(reviewModel.getReviewId());
		entity.setReviewDate(reviewModel.getReviewDate());
		entity.setComment(reviewModel.getComment());
		entity.setCourse_Order(courseOrderRepository.getReferenceById(reviewModel.getId()));

		return entity;
	}

	public ReviewModel toDto(Review review) {
		ReviewModel dto = new ReviewModel();
		dto.setReviewId(review.getReviewId());
		dto.setReviewDate(review.getReviewDate());
		dto.setComment(review.getComment());
		dto.setId(review.getCourse_Order().getId());
		dto.setCourse_Order(courseOrderConverter.toDTO(review.getCourse_Order()));
		dto.setResponseCourse(courseConverter.toResponse(review.getCourse_Order().getCourse()));
		dto.setOrderModel(orderConverter.toDTO(review.getCourse_Order().getOrder()));
		dto.setCourse_id(review.getCourse_Order().getCourse().getCourseId());
		dto.setOrder_id(review.getCourse_Order().getOrder().getOrderId());
		return dto;
	}

	public ResponseReview toResponse(Review review) {
		ResponseReview dto = new ResponseReview();
		dto.setReviewId(review.getReviewId());
		dto.setReviewDate(review.getReviewDate());
		dto.setComment(review.getComment());
		dto.setCourse_id(review.getCourse_Order().getCourse().getCourseId());
		dto.setOrder_id(review.getCourse_Order().getOrder().getOrderId());
		return dto;

	}
}
