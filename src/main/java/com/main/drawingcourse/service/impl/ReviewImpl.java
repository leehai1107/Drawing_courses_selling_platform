package com.main.drawingcourse.service.impl;

import com.main.drawingcourse.converter.ReviewConverter;
import com.main.drawingcourse.dto.Course_OrderModel;
import com.main.drawingcourse.dto.OrderModel;
import com.main.drawingcourse.dto.ResponseCourse;
import com.main.drawingcourse.dto.ReviewModel;
import com.main.drawingcourse.entity.*;
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

    @Override
    public ReviewModel addFeedBack(ReviewModel reviewModel) {


        // Chuyển đổi courseModel thành entity và thiết lập drawing category
        Review review = reviewConverter.toEntity(reviewModel);
        review.setReviewDate(LocalDate.now());

        // Lưu courseEntity
        review = reviewRepositoty.save(review);

        // Trả về courseModel đã được chuyển đổi từ entity
        return reviewConverter.toDto(review);

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

