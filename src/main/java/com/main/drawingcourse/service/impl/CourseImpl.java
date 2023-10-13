package com.main.drawingcourse.service.impl;

import com.main.drawingcourse.converter.CourseConverter;
import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.entity.Course;
import com.main.drawingcourse.entity.DrawingCategory;
import com.main.drawingcourse.entity.Level;
import com.main.drawingcourse.entity.User;
import com.main.drawingcourse.repository.CourseRepository;
import com.main.drawingcourse.repository.DrawingCategoryRepository;
import com.main.drawingcourse.repository.LevelRepository;
import com.main.drawingcourse.repository.UserRepository;
import com.main.drawingcourse.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        DrawingCategory categoryEntity = categoryRepository.findOneByDrawCategoryId(courseModel.getDrawCategoryId());
        Course courseEntity = courseConverter.toEntity(courseModel);
        courseEntity.setDrawingCategory(categoryEntity);
        courseEntity = courseRepository.save(courseEntity);

        return courseConverter.toDTO(courseEntity);


    }

    @Override
    public CourseModel findByCourseTitle(String title) {
        Course course = courseRepository.findAllCoursesByTitle(title);
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

    @Override
    public List<CourseModel> findAll() {
        List<Course> courses = courseRepository.findAll();
        List<CourseModel> courseModels = courses.stream()
                .map(courseConverter::toDTO)
                .collect(Collectors.toList());

        return courseModels;
    }

    @Override
    public List<CourseModel> findCourseByInstructorID(int instructor_id) {
        List<Course> courseEntity = courseRepository.findAllCoursesByInstructorId(instructor_id);
        List<CourseModel> courseModels = courseEntity.stream()
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
            course.setPrice(course.getPrice());
            course.setProgress(course.getProgress());
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

