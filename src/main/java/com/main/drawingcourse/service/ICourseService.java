package com.main.drawingcourse.service;

import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.entity.Course;

public interface ICourseService {
    CourseModel AddCourse(CourseModel courseModel);
}
