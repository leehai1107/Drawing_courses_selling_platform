package com.main.drawingcourse.converter;

import com.main.drawingcourse.dto.LessonModel;
import com.main.drawingcourse.entity.Lesson;
import com.main.drawingcourse.repository.CourseRepository;
import com.main.drawingcourse.repository.LessonRepository;
import com.main.drawingcourse.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LessonConverter {

    @Autowired
    LessonRepository lessonRepository;

    @Autowired
    UnitRepository unitRepository;


    public Lesson toEntity (LessonModel lessonDTO) {
        Lesson entity = new Lesson();
        entity.setLessonId(lessonDTO.getLessonId());
        entity.setContent(lessonDTO.getContent());
        entity.setTitle(lessonDTO.getTitle());
        entity.setVideoDuration(lessonDTO.getVideoduration());
        entity.setVideoUrl(lessonDTO.getVideoUrl());
        entity.setUnit(unitRepository.getReferenceById(lessonDTO.getUnitid()));
        entity.setLessonStatus(lessonDTO.isLessonstatus());

        return entity;
    }

    public LessonModel toDTO (Lesson lessonEntity) {
        LessonModel dto = new LessonModel();
        dto.setLessonId(lessonEntity.getLessonId());
        dto.setContent(lessonEntity.getContent());
        dto.setTitle(lessonEntity.getTitle());
        dto.setVideoduration(lessonEntity.getVideoDuration());
        dto.setVideoUrl(lessonEntity.getVideoUrl());
        dto.setUnitid(lessonEntity.getUnit().getUnitId());
        dto.setLessonstatus(lessonEntity.getLessonStatus());

        return dto;
    }
}
