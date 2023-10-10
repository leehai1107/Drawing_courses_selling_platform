package com.main.drawingcourse.service.impl;

import com.main.drawingcourse.converter.CourseConverter;
import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.entity.Course;
import com.main.drawingcourse.entity.DrawingCategory;
import com.main.drawingcourse.repository.CourseRepository;
import com.main.drawingcourse.repository.DrawingCategoryRepository;
import com.main.drawingcourse.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseImpl implements ICourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    DrawingCategoryRepository categoryRepository;

    @Autowired
    CourseConverter courseConverter;


    @Override
    public CourseModel AddCourse(CourseModel courseModel) {
        DrawingCategory categoryEntity = categoryRepository.findOneByDrawCategoryId(courseModel.getDrawCategoryId());
        Course courseEntity = courseConverter.toEntity(courseModel);
        courseEntity.setDrawingCategory(categoryEntity);
        courseEntity = courseRepository.save(courseEntity);

        return courseConverter.toDTO(courseEntity);
//courseRepository.createCourse(courseModel.getCourseId(),courseModel.getTitle(),courseModel.getDescription(),courseModel.getPrice(),courseModel.getRating(),courseModel.getProgress(),courseModel.getLevelId(),courseModel.getDrawCategoryId(),courseModel.getInstructorId(),courseModel.getOrderId());


    }

<<<<<<< HEAD
    public List<CourseModel> findAll() {
        List<Course> courses = courseRepository.findAll();
        List<CourseModel> courseModels = new ArrayList<>();

        for (Course course : courses) {
            CourseModel courseModel = courseConverter.toDTO(course);
            courseModels.add(courseModel);
        }

        return courseModels;
    }

    public List<DrawingCategory> findAllById(Iterable<Integer> integers) {
        return categoryRepository.findAllById(integers);
    }

    public <S extends DrawingCategory> S save(S entity) {
        return categoryRepository.save(entity);
    }

    public void delete(DrawingCategory entity) {
        categoryRepository.delete(entity);
    }

    public void deleteAll() {
        categoryRepository.deleteAll();
    }

=======
//    public List<DrawingCategory> findAll() {
//        return categoryRepository.findAll();
//    }
//
//    public List<DrawingCategory> findAllById(Iterable<Integer> integers) {
//        return categoryRepository.findAllById(integers);
//    }
//
//    public <S extends DrawingCategory> S save(S entity) {
//        return categoryRepository.save(entity);
//    }
//
//    public void delete(DrawingCategory entity) {
//        categoryRepository.delete(entity);
//    }
//
//    public void deleteAll() {
//        categoryRepository.deleteAll();
//    }ư
>>>>>>> updateNew/main
}
//}
