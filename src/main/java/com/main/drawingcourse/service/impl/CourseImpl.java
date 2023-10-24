package com.main.drawingcourse.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.main.drawingcourse.dto.ResponseCourse;
import com.main.drawingcourse.dto.ResponsePostByCate;
import com.main.drawingcourse.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.drawingcourse.converter.CourseConverter;
import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.entity.Course;
import com.main.drawingcourse.entity.DrawingCategory;
import com.main.drawingcourse.repository.CourseRepository;
import com.main.drawingcourse.repository.DrawingCategoryRepository;
import com.main.drawingcourse.repository.LevelRepository;
import com.main.drawingcourse.repository.UserRepository;
import com.main.drawingcourse.service.ICourseService;

@Service
public class CourseImpl implements ICourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    DrawingCategoryRepository categoryRepository;

    @Autowired
    CourseConverter courseConverter;

    @Autowired
    LevelRepository levelRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DrawingCategoryRepository drawingCategoryRepository;


    @Override
    public CourseModel AddCourse(CourseModel courseModel) {
        Course existingCourse = courseRepository.findCoursesByTitleAndInstructorID(courseModel.getTitle(), courseModel.getInstructorId());
        List<User> instructor = userRepository.findAllInstructor();
        if (existingCourse !=null ) {
            throw new IllegalArgumentException("Course already exists");
        }

        DrawingCategory categoryEntity = categoryRepository.findOneByDrawCategoryId(courseModel.getDrawCategoryId());
        Course courseEntity = courseConverter.toEntity(courseModel);
        courseEntity.setDrawingCategory(categoryEntity);
        courseEntity = courseRepository.save(courseEntity);

        return courseConverter.toDTO(courseEntity);
    }

    @Override
    public CourseModel findByCourseTitle(String title) {
        Course course = courseRepository.findCoursesByTitle(title);
        if (course != null) {
            return courseConverter.toDTO(course);
        }
        return new CourseModel();
    }

    @Override
    public CourseModel GetCoursebyid(int id) {
        var course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            return courseConverter.toDTO(course);

        }
        return new CourseModel();
    }

    public List<ResponseCourse> findAll() {
        List<ResponseCourse> courseModels = courseRepository.findAll().stream()
                .map(courseConverter::toResponse)
                .collect(Collectors.toList());

        return courseModels;

    }

    @Override
    public List<CourseModel> findCourseByInstructorID(int instructorId) {
        List<Course> courseEntities = courseRepository.findAllCoursesByInstructorId(instructorId);
        List<CourseModel> courseModels = courseEntities.stream()
                .map(courseConverter::toDTO)
                .collect(Collectors.toList());

        return courseModels;

    }


    @Override

    public void DeleteCoursebyid(int id) {
        var course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            var courseDTO = courseConverter.toDTO(course);
            courseRepository.delete(course);
        }
    }

    @Override
    public void UpdateCourse(CourseModel CourseModel) {
        Course course = courseConverter.toEntity(CourseModel);

        if (course != null) {
            // Update the course entity with data from CourseModel
            course.setDescription(CourseModel.getDescription());
            course.setPrice(CourseModel.getPrice());
            course.setRating(CourseModel.getRating());
            course.setTitle(CourseModel.getTitle());

            // Update the drawing category, level, and user, similar to the way you did it
            var draw = drawingCategoryRepository.findById(CourseModel.getDrawCategoryId()).orElse(null);
            if (draw != null) {
                course.setDrawingCategory(draw);
            }

            var level = levelRepository.findById(CourseModel.getLevelId()).orElse(null);
            if (level != null) {
                course.setLevel(level);
            }

            var userByIdAndRole = userRepository.findByIdAndRole(CourseModel.getInstructorId()).orElse(null);
            if (userByIdAndRole != null) {
                course.setUser(userByIdAndRole);
            }

            // Update the courseImage if it's not null in CourseModel
            if (CourseModel.getCourseImage() != null) {
                course.setCourseImage(CourseModel.getCourseImage());
            }

            // Finally, save the updated course entity
            course = courseRepository.save(course);
        }
    }


    @Override
    public void editCourse(int courseId, CourseModel courseModel) {
        Course existingCourse = courseRepository.findCourseByID(courseId);

        if(existingCourse != null){
            // Update the existing course with the new data from the courseModel
            BeanUtils.copyProperties(courseModel, existingCourse, "courseId");

            // Save the updated course
            courseRepository.save(existingCourse);
        }
            }

    @Override
	public List<CourseModel> findCoursesByPriceRange(double start_price, double end_price) {
        List<Course> courseEntity = courseRepository.findCoursesByPriceRange(start_price,end_price);
        List<CourseModel> courseModels = courseEntity.stream()
                .map(courseConverter::toDTO)
                .collect(Collectors.toList());
        return courseModels;
    }

    @Override
    public List<CourseModel> findAllCourseHasOrder(String name) {
        List<Course> courseEntity = courseRepository.findAllCourseHasOrder(name);
        List<CourseModel> courseModels = courseEntity.stream()
                .map(courseConverter::toDTO)
                .collect(Collectors.toList());

        return courseModels;
    }

    @Override
    public List<CourseModel> findAllCourseOfInstructorByUserName(String name) {
        List<Course> courseEntity = courseRepository.findAllCourseOfInstructorByUserName(name);
        List<CourseModel> courseModels = courseEntity.stream()
                .map(courseConverter::toDTO)
                .collect(Collectors.toList());

        return courseModels;
    }

    @Override
    public List<CourseModel> findTop4BestSellerCourse() {
        List<CourseModel> courseModels = courseRepository.findTop4BestSellerCourse().stream()
                .map(courseConverter::toDTO)
                .collect(Collectors.toList());

        return courseModels;
    }


    @Override
    public Course findByCoursebyId(int id) {
        var course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            return course;

        }
        return new Course();
    }

    public List<ResponseCourse> viewcoursehasstatustrue(boolean status){
        List<ResponseCourse> courseModels = courseRepository.viewcoursewithstatustrue(status).stream()
                .map(courseConverter::toResponse)
                .collect(Collectors.toList());
        return courseModels;
    }




}


