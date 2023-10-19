package com.main.drawingcourse.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.main.drawingcourse.dto.ResponseCourse;
import com.main.drawingcourse.entity.User;
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

//        List<ResponsePostByCate> postModels = postRepository.findAll().stream()
//                .map(postConverter::toResponse)
//                .collect(Collectors.toList());
//
//        return postModels;
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

        if(course != null){
            // Update the course entity with data from CourseModel
            course.setDescription(course.getDescription());
            course.setCourseImage(course.getCourseImage());
            course.setPrice(course.getPrice());
            course.setRating(course.getRating());
            course.setTitle(course.getTitle());

            // Update the drawing category, level, and user, similar to the way you did it
            var draw = drawingCategoryRepository.findById(course.getDrawingCategory().getDrawCategoryId()).orElse(null);
            if (draw != null) {
                course.setDrawingCategory(draw);
            }

            var level = levelRepository.findById(course.getLevel().getLevelId()).orElse(null);
            if (level != null) {
                course.setLevel(level);
            }

            var userByIdAndRole = userRepository.findByIdAndRole(course.getUser().getUserId()).orElse(null);
            if (userByIdAndRole != null) {
                course.setUser(userByIdAndRole);
            }

            // Finally, save the updated course entity
            course = courseRepository.save(course);

            // You can return the updated CourseModel if needed
            CourseModel updatedCourseModel = courseConverter.toDTO(course);
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
    public List<CourseModel> findAllCourseHasOrder() {
        List<Course> courseEntity = courseRepository.findAllCourseHasOrder();
        List<CourseModel> courseModels = courseEntity.stream()
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





  /*   @Override
    public CourseModel EditCourse(int id, CourseModel courseModel) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course not found"));

        // Update the course details
        course.setTitle(courseModel.getTitle());
        course.setDescription(courseModel.getDescription());
        course.setPrice(courseModel.getPrice());
        course.setRating(courseModel.getRating());
        course.setProgress(courseModel.getProgress());

        // Update the relationships
        int instructorId = courseModel.getInstructorId();
        if (instructorId > 0) {
           User instructor = userRepository.findByIdAndRole(instructorId)
                 .orElseThrow(() -> new EntityNotFoundException("Instructor not found"));
            course.setUser(instructor);
        }

        int levelId = courseModel.getLevelId();
        if (levelId > 0) {
            Level level = levelRepository.findById(levelId)
                    .orElseThrow(() -> new EntityNotFoundException("Level not found"));
            course.setLevel(level);
        }


        int drawingCategoryId = courseModel.getDrawCategoryId();
        if (drawingCategoryId > 0) {
            DrawingCategory drawingCategory = drawingCategoryRepository.findById(drawingCategoryId)
                    .orElseThrow(() -> new EntityNotFoundException("Drawing Category not found"));
            course.setDrawingCategory(drawingCategory);
        }

        // Save the updated course
        Course updatedCourse = courseRepository.save(course);

        return courseConverter.toDTO(updatedCourse);

    }*/

}

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

