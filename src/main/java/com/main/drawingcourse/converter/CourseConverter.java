package com.main.drawingcourse.converter;

import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.entity.Course;
import com.main.drawingcourse.repository.DrawingCategoryRepository;
import com.main.drawingcourse.repository.LevelRepository;
import com.main.drawingcourse.repository.OrderRepository;
import com.main.drawingcourse.repository.UserRepository;
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

    public Course toEntity(CourseModel courseModel) {
        Course entity = new Course();
        entity.setCourseId(courseModel.getCourseId());
        entity.setCourseImage(courseModel.getCourseImage());
        entity.setTitle(courseModel.getTitle());
        entity.setDescription(courseModel.getDescription());
        entity.setPrice(courseModel.getPrice());
        entity.setRating(courseModel.getRating());
        entity.setLevel(levelRepository.getReferenceById(courseModel.getLevelId()));
        entity.setDrawingCategory(categoryRepository.getReferenceById(courseModel.getDrawCategoryId()));
        entity.setUser(userRepository.getReferenceById(courseModel.getInstructorId()));
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
        dto.setLevelId(courseEntity.getLevel().getLevelId());
        dto.setDrawCategoryId(courseEntity.getDrawingCategory().getDrawCategoryId());
        dto.setInstructorId(courseEntity.getUser().getUserId());

        return dto;
    }
}
