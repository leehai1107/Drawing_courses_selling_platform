package com.main.drawingcourse.converter;

import com.main.drawingcourse.dto.CourseModel;
<<<<<<< HEAD
import com.main.drawingcourse.dto.ResponseCourse;
=======
import com.main.drawingcourse.dto.DrawingCategoryModel;
import com.main.drawingcourse.dto.LevelModel;
>>>>>>> newup/main
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
<<<<<<< HEAD

    @Autowired
    UserConverter userConverter;

    @Autowired
    LevelConverter levelConverter;

    @Autowired
    DrawingCateforyConverter drawingCateforyConverter;

=======
    @Autowired
    DrawingCateforyConverter drawingCateforyConverter;
    @Autowired
    LevelConverter levelConverter;
    @Autowired
    UserConverter userConverter;
>>>>>>> newup/main
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

        return dto;
    }

    public ResponseCourse toResponse(Course course) {
        ResponseCourse dto = new ResponseCourse();

        dto.setCourseid(course.getCourseId());
        dto.setDescription(course.getDescription());
        dto.setTitle(course.getTitle());
        dto.setPrice(course.getPrice());
        dto.setRating(course.getRating());
        dto.setCourseImg(course.getCourseImage());

        dto.setUserinfo(userConverter.toResponse(course.getUser()));
        dto.setLevelinfo(levelConverter.toDto(course.getLevel()));
        dto.setCateInfo(drawingCateforyConverter.toDto(course.getDrawingCategory()));

        return dto;
    }
}
