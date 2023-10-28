package com.main.drawingcourse.converter;

import com.main.drawingcourse.dto.CourseModel;

import com.main.drawingcourse.dto.ResponseCourse;

import com.main.drawingcourse.dto.DrawingCategoryModel;
import com.main.drawingcourse.dto.LevelModel;

import com.main.drawingcourse.entity.Course;
import com.main.drawingcourse.entity.Lesson;
import com.main.drawingcourse.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CourseConverter {

    @Autowired
    DrawingCategoryRepository categoryRepository;

    @Autowired
    LevelRepository levelRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    LessonRepository lessonRepository;
    @Autowired
    UserConverter userConverter;

    @Autowired
    LevelConverter levelConverter;

    @Autowired
    DrawingCateforyConverter drawingCateforyConverter;


    public Course toEntity(CourseModel courseModel) {
        Course entity = new Course();
        entity.setCourseId(courseModel.getCourseId());
        entity.setCourseImage(courseModel.getCourseImage());
        entity.setTitle(courseModel.getTitle());
        entity.setDescription(courseModel.getDescription());
        entity.setPrice(courseModel.getPrice());
        entity.setRating(courseModel.getRating());
        entity.setDrawingCategory(categoryRepository.getReferenceById(courseModel.getDrawCategoryId()));
        entity.setLevel(levelRepository.getReferenceById(courseModel.getLevelId()));
        entity.setUser(userRepository.getReferenceById(courseModel.getInstructorId()));
        entity.setStatus(courseModel.isStatus());


        return entity;
    }

    public CourseModel toDTO(Course courseEntity) {
        CourseModel dto = new CourseModel();
        dto.setCourseId(courseEntity.getCourseId());
        dto.setCourseImage(courseEntity.getCourseImage());
        dto.setTitle(courseEntity.getTitle());
        dto.setDescription(courseEntity.getDescription());
        dto.setPrice(courseEntity.getPrice());
        dto.setRating(courseEntity.getRating());
        dto.setDrawCategoryId(courseEntity.getDrawingCategory().getDrawCategoryId());
        dto.setLevelId(courseEntity.getLevel().getLevelId());
        dto.setInstructorId(courseEntity.getUser().getUserId());
        dto.setDrawingCategoryModel(drawingCateforyConverter.toDto(courseEntity.getDrawingCategory()));
        dto.setLevelModel(levelConverter. toDto(courseEntity.getLevel()));
        dto.setUserModelRespone(userConverter.toResponse(courseEntity.getUser()));
        dto.setStatus(courseEntity.isStatus());
        return dto;
    }

    public ResponseCourse toResponse(Course course) {
        ResponseCourse dto = new ResponseCourse();

        dto.setCourseId(course.getCourseId());
        dto.setDescription(course.getDescription());
        dto.setTitle(course.getTitle());
        dto.setPrice(course.getPrice());
        dto.setRating(course.getRating());
        dto.setCourseImage(course.getCourseImage());
        dto.setDrawCategoryId(course.getDrawingCategory().getDrawCategoryId());
        dto.setLevelId(course.getLevel().getLevelId());
        dto.setInstructorId(course.getUser().getUserId());
        dto.setDrawingCategoryModel(drawingCateforyConverter.toDto(course.getDrawingCategory()));
        dto.setLevelModel(levelConverter. toDto(course.getLevel()));
        dto.setUserModelRespone(userConverter.toResponse(course.getUser()));
        dto.setStatus(course.isStatus());
        dto.setLession_count(course.getLessons().size());
        return dto;
    }
}
