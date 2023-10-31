package com.main.drawingcourse.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.main.drawingcourse.dto.LessonModel;
import com.main.drawingcourse.dto.ResponseLessonByCourseId;
import com.main.drawingcourse.entity.Lesson;
import com.main.drawingcourse.repository.CourseRepository;
import com.main.drawingcourse.repository.LessonRepository;

@Component
public class LessonConverter {

	@Autowired
	LessonRepository lessonRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CourseConverter courseConverter;

	public Lesson toEntity(LessonModel lessonDTO) {
		Lesson entity = new Lesson();
		entity.setLessonId(lessonDTO.getLessonId());
		entity.setContent(lessonDTO.getContent());
		entity.setTitle(lessonDTO.getTitle());
		entity.setVideoDuration(lessonDTO.getVideoduration());
		entity.setVideoUrl(lessonDTO.getVideoUrl());
		entity.setCourse(courseRepository.getReferenceById(lessonDTO.getCourseId()));
		entity.setLessonStatus(lessonDTO.isLessonstatus());

		return entity;
	}

	public LessonModel toDTO(Lesson lessonEntity) {
		LessonModel dto = new LessonModel();
		dto.setLessonId(lessonEntity.getLessonId());
		dto.setContent(lessonEntity.getContent());
		dto.setTitle(lessonEntity.getTitle());
		dto.setVideoduration(lessonEntity.getVideoDuration());
		dto.setVideoUrl(lessonEntity.getVideoUrl());
		dto.setCourseId(lessonEntity.getCourse().getCourseId());
		dto.setLessonstatus(lessonEntity.getLessonStatus());

		return dto;
	}

	public ResponseLessonByCourseId toResponse(Lesson lesson) {
		ResponseLessonByCourseId dto = new ResponseLessonByCourseId();

		dto.setLessonId(lesson.getLessonId());
		dto.setTitle(lesson.getTitle());
		dto.setContent(lesson.getContent());
		dto.setVideoUrl(lesson.getVideoUrl());
		dto.setVideoduration(lesson.getVideoDuration());
		dto.setLessonstatus(lesson.getLessonStatus());

		dto.setCourseInfo(courseConverter.toDTO(lesson.getCourse()));

		return dto;
	}
}
