package com.main.drawingcourse.service.impl;

import com.main.drawingcourse.converter.ReviewConverter;
import com.main.drawingcourse.dto.*;
import com.main.drawingcourse.entity.*;
import com.main.drawingcourse.repository.Course_OrderRepository;
import com.main.drawingcourse.repository.ReviewRepositoty;
import com.main.drawingcourse.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service


public class ReviewImpl implements IReviewService {
    @Autowired
    ReviewRepositoty reviewRepositoty;
    @Autowired
    ReviewConverter reviewConverter;
    @Autowired
    Course_OrderRepository courseOrderRepository;

    @Override
    public ResponseReview addFeedBack(ReviewModel reviewModel) {
        int courseId = reviewModel.getCourse_id();
        int orderId = reviewModel.getOrder_id();

        int id = courseOrderRepository.findCourseAndOrderID(courseId, orderId);
        if (id != 0) {
            Review review = reviewConverter.toEntity(reviewModel);
            Course_Order courseOrder = courseOrderRepository.getReferenceById(id);
            if (courseOrder != null) {
                review.setCourse_Order(courseOrder);
                review.setReviewDate(LocalDate.now());
                review = reviewRepositoty.save(review);
                return reviewConverter.toResponse(review);
            } else {
                // Xử lý trường hợp không tìm thấy đối tượng Course_Order tương ứng
                return null; // hoặc trả về response error/tin nhắn thông báo cho người dùng
            }
        }

        return null;
    }

    @Override
    public List<ReviewModel> findAllFeedBackByUserId(int id) {
        List<ReviewModel> reviewModels = reviewRepositoty.findAllFeedBacksByUserId(id).stream()
                .map(reviewConverter::toDto)
                .collect(Collectors.toList());

        return reviewModels;
    }

    @Override
    public List<ReviewModel> findAllFeedBackByCourse(int id) {
        List<ReviewModel> reviewModels = reviewRepositoty.findAllFeedBacksByCourse(id).stream()
                .map(reviewConverter::toDto)
                .collect(Collectors.toList());

        return reviewModels;
    }
}

