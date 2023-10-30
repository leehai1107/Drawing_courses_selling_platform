package com.main.drawingcourse.service;

import java.util.List;

import com.main.drawingcourse.dto.LessonModel;
import com.main.drawingcourse.dto.ResponseLessonByCourseId;

public interface ILessonService {

	LessonModel AddLesson(LessonModel lessonModel);

	List<ResponseLessonByCourseId> findLessonsByCourseID(int courseid);
}
