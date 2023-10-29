package com.main.drawingcourse.service;

import com.main.drawingcourse.dto.LessonModel;
import com.main.drawingcourse.dto.ResponseLessonByCourseId;

import java.util.List;

public interface ILessonService {

    LessonModel AddLesson (LessonModel lessonModel);


    List<ResponseLessonByCourseId> findLessonsByCourseID(int courseid);
}
