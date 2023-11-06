package com.main.drawingcourse.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.drawingcourse.converter.LessonConverter;
import com.main.drawingcourse.dto.LessonModel;
import com.main.drawingcourse.dto.ResponseLessonByCourseId;
import com.main.drawingcourse.entity.Lesson;
import com.main.drawingcourse.repository.LessonRepository;
import com.main.drawingcourse.service.ILessonService;

@Service
public class LessonImpl implements ILessonService {

	@Autowired
	LessonConverter lessonConverter;

	@Autowired
	LessonRepository lessonRepository;

	@Override
	public LessonModel AddLesson(LessonModel lessonModel) {
		Lesson lessonEntity = lessonConverter.toEntity(lessonModel);
		lessonEntity = lessonRepository.save(lessonEntity);

		return lessonConverter.toDTO(lessonEntity);
	}

	@Override
	public List<ResponseLessonByCourseId> findLessonsByCourseID(int courseid) {
		List<Lesson> lessonEntity = lessonRepository.findLessonsByID(courseid);
		List<ResponseLessonByCourseId> lessonModels = lessonEntity.stream().map(lessonConverter::toResponse)
				.collect(Collectors.toList());

		return lessonModels;

	}
	
	@Override
	public void editLesson(List<LessonModel> list) {
		int courseid = list.get(0).getCourseId();
		lessonRepository.deleteLessonsByCourseId(courseid);
		for(LessonModel i: list) {
			AddLesson(i);
		}
	}
}
