package com.main.drawingcourse.service;

import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.entity.Course;
import org.springframework.data.domain.Example;

import java.util.List;

public interface ICourseService {
    CourseModel AddCourse(CourseModel courseModel);

    List<CourseModel> findAll();
}
